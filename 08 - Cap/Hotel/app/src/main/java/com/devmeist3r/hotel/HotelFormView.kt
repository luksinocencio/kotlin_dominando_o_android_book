package com.devmeist3r.hotel

interface HotelFormView {
  fun showHotel(hotel: Hotel)
  fun errorInvalidHotel()
  fun errorSaveHotel()
}
