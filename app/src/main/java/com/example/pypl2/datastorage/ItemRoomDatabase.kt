package com.example.pypl2.datastorage

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase:RoomDatabase() {
    abstract fun itemDao(): ItemDao


}