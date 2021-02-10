package com.devmeist3r.hotel

import android.app.Application
import com.devmeist3r.hotel.di.androidModule
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin


class HotelApp: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin(this, listOf(androidModule))
  }

  override fun onTerminate() {
    super.onTerminate()
    stopKoin()
  }
}
