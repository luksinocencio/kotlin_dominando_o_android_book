package com.devmeist3r.hotel.details

import com.devmeist3r.hotel.model.Hotel

interface HotelDetailsView {
  fun showHotelDetails(hotel: Hotel)
  fun errorHotelNotFoound()
}
