package com.mindmatrix.rakta.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Donor::class, DonationLog::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RaktaDatabase : RoomDatabase() {

    abstract fun dao(): RaktaDao

    companion object {
        @Volatile
        private var INSTANCE: RaktaDatabase? = null

        fun get(context: Context): RaktaDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RaktaDatabase::class.java,
                    "rakta.db"
                ).build().also { INSTANCE = it }
            }
    }
}
