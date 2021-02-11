package com.devmeist3r.hotel.form

import com.devmeist3r.hotel.model.Hotel

interface HotelFormView {
  fun showHotel(hotel: Hotel)
  fun errorInvalidHotel()
  fun errorSaveHotel()
}
