package com.example.nutrishop.Model

import android.os.Parcel
import android.os.Parcelable


data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: String = "",
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0,
    var nutrients: MutableList<Nutrient> = mutableListOf()

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readDouble(),
        nutrients = mutableListOf<Nutrient>().apply {
            parcel.readList(this, Nutrient::class.java.classLoader)
        }
    )


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(description)
        dest.writeString(picUrl)
        dest.writeDouble(price)
        dest.writeDouble(rating)
        dest.writeList(nutrients)
    }

    companion object CREATOR : Parcelable.Creator<ItemModel> {
        override fun createFromParcel(parcel: Parcel): ItemModel {
            return ItemModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemModel?> {
            return arrayOfNulls(size)
        }
    }
}

