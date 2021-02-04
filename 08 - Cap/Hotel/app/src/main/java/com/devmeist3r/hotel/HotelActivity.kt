package com.devmeist3r.hotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView

class HotelActivity: AppCompatActivity(),
  HotelListFragment.OnHotelClickListener,
  HotelListFragment.OnHotelDeletedListener,
  SearchView.OnQueryTextListener,
  MenuItem.OnActionExpandListener,
  HotelFormFragment.OnHotelSavedListener {


  private var hotelSelected: Long = -1
  private var lastSearchTerm: String = ""
  private var searchView: SearchView? = null
  private val listFragment: HotelListFragment by lazy {
    supportFragmentManager.findFragmentById( R.id.fragmentList) as HotelListFragment
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hotel)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState?.putLong(EXTRA_HOTEL_ID_SELECTED, hotelSelected)
    outState?.putString(EXTRA_SEARCH_TERM, lastSearchTerm)
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    super.onRestoreInstanceState(savedInstanceState)
    hotelSelected = savedInstanceState?.getLong(EXTRA_HOTEL_ID_SELECTED) ?: 0
    lastSearchTerm = savedInstanceState?.getString(EXTRA_SEARCH_TERM)?: ""
  }

  override fun onHotelClick(hotel: Hotel) {
    if (isTablet()) {
      hotelSelected = hotel.id
      showDetailsFragment(hotel.id)
    } else {
      showDetailtsActivity(hotel.id)
    }
  }

  private fun isTablet() = resources.getBoolean(R.bool.tablet)
  private fun isSmartphone() = resources.getBoolean(R.bool.smartphone)

  private fun showDetailsFragment(hotelId: Long) {
    searchView?.setOnQueryTextListener(null)
    val fragment = HotelDetailsFragment.newInstance(hotelId)
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.details, fragment, HotelDetailsFragment.TAG_DETAILS)
      .commit()
  }

  /**
   *
   * carregar as ações que aparecerão na action bar
   *
   * */
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.hotel, menu)
    val searchItem = menu?.findItem(R.id.action_search)
    searchItem?.setOnActionExpandListener(this)
    searchView = searchItem?.actionView as SearchView
    searchView?.queryHint = getString(R.string.hint_search)
    searchView?.setOnQueryTextListener(this)
    if (lastSearchTerm.isNotEmpty()) {
      Handler().post {
        val query = lastSearchTerm
        searchItem.expandActionView()
        searchView?.setQuery(query, true)
        searchView?.clearFocus()
      }
    }
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
      R.id.action_info -> AboutDialogFragment().show(supportFragmentManager, "sobre")
      R.id.action_new -> HotelFormFragment.newInstance().open(supportFragmentManager)
    }

    return super.onOptionsItemSelected(item)
  }

  override fun onQueryTextSubmit(query: String?) = true

  override fun onQueryTextChange(newText: String?): Boolean {
    lastSearchTerm = newText?:""
    listFragment.search(lastSearchTerm)
    return true
  }

  override fun onMenuItemActionExpand(p0: MenuItem?) = true

  override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
    lastSearchTerm = ""
    listFragment.clearSearch()
    return true
  }

  private fun showDetailtsActivity(hotelId: Long) {
    HotelDetailsActivity.open(this, hotelId)
  }

  companion object {
    const val EXTRA_SEARCH_TERM = "lastSearch"
    const val EXTRA_HOTEL_ID_SELECTED = "lastSelectedId"
  }

  override fun onHotelsDeleted(hotels: List<Hotel>) {
    if (hotels.find { it.id == hotelSelected } != null) {
      val fragment = supportFragmentManager.findFragmentByTag(HotelDetailsFragment.TAG_DETAILS)
      if (fragment != null) {
        supportFragmentManager
          .beginTransaction()
          .remove(fragment)
          .commit()
      }
    }
  }

  override fun onHotelSaved(hotel: Hotel) {
    listFragment.search(lastSearchTerm)
  }

}
