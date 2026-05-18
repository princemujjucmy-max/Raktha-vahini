package com.mindmatrix.rakta.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A registered blood donor.
 *
 * [isMe] marks the single profile that belongs to the device owner.
 * [phone] is never shown on a public list screen — it is only handed to the
 * dialer through an Intent, keeping the directory privacy-focused.
 */
@Entity(tableName = "donors")
data class Donor(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val bloodGroup: BloodGroup,
    val phone: String,
    val locationName: String,
    val distanceKm: Int,
    val lastDonationDate: Long?,      // epoch millis; null = never donated
    val readyToDonate: Boolean = true,
    val isMe: Boolean = false
)
