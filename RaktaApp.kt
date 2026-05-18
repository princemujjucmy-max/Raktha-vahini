package com.mindmatrix.rakta

import android.app.Application
import com.mindmatrix.rakta.data.RaktaDatabase
import com.mindmatrix.rakta.data.RaktaRepository
import com.mindmatrix.rakta.util.Notifications

class RaktaApp : Application() {

    /** App-wide repository, created lazily on first use. */
    val repository: RaktaRepository by lazy {
        RaktaRepository(RaktaDatabase.get(this).dao())
    }

    override fun onCreate() {
        super.onCreate()
        Notifications.createChannel(this)
    }
}
