package com.mindmatrix.rakta.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RaktaDao {

    @Query("SELECT * FROM donors WHERE isMe = 0 ORDER BY distanceKm ASC")
    fun observeDonors(): Flow<List<Donor>>

    @Query("SELECT * FROM donors WHERE isMe = 1 LIMIT 1")
    fun observeMyProfile(): Flow<Donor?>

    @Query("SELECT COUNT(*) FROM donors")
    suspend fun donorCount(): Int

    @Insert
    suspend fun insertDonor(donor: Donor): Long

    @Insert
    suspend fun insertDonors(donors: List<Donor>)

    @Update
    suspend fun updateDonor(donor: Donor)

    @Query("SELECT * FROM donation_logs ORDER BY date DESC")
    fun observeLogs(): Flow<List<DonationLog>>

    @Insert
    suspend fun insertLog(log: DonationLog)
}
