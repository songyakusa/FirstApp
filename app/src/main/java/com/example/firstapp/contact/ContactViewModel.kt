package com.example.firstapp.contact

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.firstapp.database.NamelistDao
import com.example.newfirstapp.database.Namelist
import kotlinx.coroutines.*


class ContactViewModel(
    val database: NamelistDao,
    application: Application ) : AndroidViewModel(application) {


    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var contact = MutableLiveData<Namelist?>()



    private suspend fun getTonameFromDatabase(): Namelist? {
        return withContext(Dispatchers.IO) {
            var name = database.getToname()
            name
        }
    }

    private fun initializeToContace() {
        uiScope.launch {
            contact.value = getTonameFromDatabase()
        }
    }

    init {
        initializeToContace()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private suspend fun insert(night: Namelist) {
        withContext(Dispatchers.IO) {
            database.insert(night)
        }
    }


    private val namenew = database.getAll()

    val namesString = Transformations.map(namenew) { nights ->
    }


    fun onStartTracking() {
        uiScope.launch {
            val newName = Namelist()
            insert(newName)
            contact.value = getTonameFromDatabase()
        }
    }

    val startButtonVisible = Transformations.map(contact) {
        it == null
    }
    private var _showSnackbarEvent = MutableLiveData<Boolean>()

    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = true
    }


}