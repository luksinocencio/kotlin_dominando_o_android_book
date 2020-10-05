package com.devmeist3r.activityintents

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Pessoa(val nome: String, val idade: Int) : Parcelable
