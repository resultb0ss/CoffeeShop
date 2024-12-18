package com.example.coffeeshop.Model

import android.os.Parcel
import android.os.Parcelable

data class ItemsModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var extra: String = "",
    var categoryId: String = "",

    ) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),

        ) {

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(description)
        dest.writeStringList(picUrl)
        dest.writeDouble(price)
        dest.writeString(extra)
        dest.writeString(categoryId)
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(source: Parcel): ItemsModel {
            return ItemsModel(source)
        }

        override fun newArray(size: Int): Array<ItemsModel?> {
            return arrayOfNulls(size)
        }

    }

}
