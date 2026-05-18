package com.mindmatrix.rakta.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/** One entry in the device owner's personal donation history. */
@Entity(tableName = "donation_logs")
data class DonationLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: Long,                  // epoch millis
    val location: String,
    val note: String
)
