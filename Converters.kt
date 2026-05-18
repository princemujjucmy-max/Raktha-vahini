package com.mindmatrix.rakta.data

import androidx.room.TypeConverter

/** Stores [BloodGroup] in Room as its short label (e.g. "O+"). */
class Converters {
    @TypeConverter
    fun fromBloodGroup(group: BloodGroup): String = group.label

    @TypeConverter
    fun toBloodGroup(label: String): BloodGroup = BloodGroup.fromLabel(label)
}
