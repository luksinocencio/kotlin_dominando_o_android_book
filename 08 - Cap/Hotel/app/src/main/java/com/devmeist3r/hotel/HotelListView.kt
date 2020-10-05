package com.devmeist3r.hotel

interface HotelListView {
  fun showHotels(hotels: List<Hotel>)
  fun showHotelDetails(hotel: Hotel)
}
