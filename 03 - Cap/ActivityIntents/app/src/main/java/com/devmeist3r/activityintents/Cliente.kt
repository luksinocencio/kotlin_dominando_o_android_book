package com.devmeist3r.activityintents

import android.os.Parcelable
import org.parceler.Parcel
import org.parceler.ParcelConstructor


class Cliente(var codigo: Int, var nome: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "" // << Elvis operator
    ) {
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeInt(codigo)
        parcel.writeString(nome)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: android.os.Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)

        }
    }
}



