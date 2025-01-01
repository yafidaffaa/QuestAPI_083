package com.example.mysqldatabse

import android.app.Application
import com.example.mysqldatabse.dependenciesinjection.AppContainer
import com.example.mysqldatabse.dependenciesinjection.MahasiswaContainer

class MhsApplications: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}