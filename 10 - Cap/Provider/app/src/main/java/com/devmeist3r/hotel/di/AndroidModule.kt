package com.devmeist3r.hotel.di

import com.devmeist3r.hotel.details.HotelDetailsPresenter
import com.devmeist3r.hotel.details.HotelDetailsView
import com.devmeist3r.hotel.form.HotelFormPresenter
import com.devmeist3r.hotel.form.HotelFormView
import com.devmeist3r.hotel.list.HotelListPresenter
import com.devmeist3r.hotel.list.HotelListView
import com.devmeist3r.hotel.repository.memory.HotelRepository
import com.devmeist3r.hotel.repository.sqlite.SQLiteRepository
import org.koin.dsl.module.module


val androidModule = module {
  single { this }

  single {
    SQLiteRepository(ctx = get()) as HotelRepository
  }

  factory { (view: HotelListView) ->
    HotelListPresenter(
      view,
      repository = get()
    )
  }

  factory { (view: HotelDetailsView) ->
    HotelDetailsPresenter(
      view,
      repository = get()
    )
  }

  factory { (view: HotelFormView) ->
    HotelFormPresenter(
      view,
      repository = get()
    )
  }
}
