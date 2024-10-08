package com.example.pypl2.datastorage


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")

    val itemName: String,
    @ColumnInfo(name = "price")

    val itemPrice: Double,
    @ColumnInfo(name = "quantity")

    val quantityInStock: Int
)