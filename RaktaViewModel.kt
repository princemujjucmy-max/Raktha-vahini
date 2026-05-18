package com.mindmatrix.rakta

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mindmatrix.rakta.data.DonationLog
import com.mindmatrix.rakta.data.Donor
import com.mindmatrix.rakta.util.Notifications
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** Everything the UI needs in one immutable snapshot. */
data class RaktaUiState(
    val myProfile: Donor? = null,
    val donors: List<Donor> = emptyList(),
    val logs: List<DonationLog> = emptyList()
)

class RaktaViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = (app as RaktaApp).repository

    val uiState: StateFlow<RaktaUiState> =
        combine(repository.myProfile, repository.donors, repository.logs) { me, donors, logs ->
            RaktaUiState(myProfile = me, donors = donors, logs = logs)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), RaktaUiState())

    init {
        viewModelScope.launch { repository.seedIfEmpty() }
    }

    fun saveProfile(updated: Donor) = viewModelScope.launch {
        repository.updateDonor(updated)
    }

    fun setReadyToDonate(ready: Boolean) = viewModelScope.launch {
        uiState.value.myProfile?.let { repository.updateDonor(it.copy(readyToDonate = ready)) }
    }

    fun logDonation(location: String, note: String, date: Long) = viewModelScope.launch {
        val log = DonationLog(date = date, location = location.trim(), note = note.trim())
        repository.logDonation(log, uiState.value.myProfile)
        Notifications.showThankYou(getApplication())
    }
}
