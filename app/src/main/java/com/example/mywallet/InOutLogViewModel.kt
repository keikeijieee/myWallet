package com.example.mywallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class InOutLogViewModel(application: Application):AndroidViewModel(application) {

    //ViewModel to maintain a reference to the repository
    private val repository: InOutLogRepository

    val allLogs : LiveData<List<InOutLog>>

    init{
        //Get reference to DAO
        val inOutLogDao = InOutLogDatabase
            .getDatabase(application)
            .inOutLogDao()

        repository = InOutLogRepository(inOutLogDao)
        allLogs = repository.allLogs
    }

    fun insertLog(inOutLog:InOutLog) = viewodelScope.launce{
        repository.insertLog((inOutLog))
    }
}