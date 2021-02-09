package com.devmeist3r.hotel.list

import com.devmeist3r.hotel.model.Hotel

interface HotelListView {
  fun showHotels(hotels: List<Hotel>)
  fun showHotelDetails(hotel: Hotel)
  fun showDeleteMode()
  fun hideDeleteMode()
  fun showSelectedHotels(hotels: List<Hotel>)
  fun updateSelectionCountText(count: Int)
  fun showMessageHotelsDeleted(count: Int)
}
