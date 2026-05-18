package com.mindmatrix.rakta.data

import kotlinx.coroutines.flow.Flow

/** Single source of truth for donor and donation-log data. */
class RaktaRepository(private val dao: RaktaDao) {

    val donors: Flow<List<Donor>> = dao.observeDonors()
    val myProfile: Flow<Donor?> = dao.observeMyProfile()
    val logs: Flow<List<DonationLog>> = dao.observeLogs()

    suspend fun seedIfEmpty() {
        if (dao.donorCount() == 0) {
            dao.insertDonor(SeedData.myProfile())
            dao.insertDonors(SeedData.sampleDonors())
        }
    }

    suspend fun updateDonor(donor: Donor) = dao.updateDonor(donor)

    /** Records a donation and advances the owner's last-donation date. */
    suspend fun logDonation(log: DonationLog, myProfile: Donor?) {
        dao.insertLog(log)
        if (myProfile != null) {
            dao.updateDonor(myProfile.copy(lastDonationDate = log.date))
        }
    }
}
