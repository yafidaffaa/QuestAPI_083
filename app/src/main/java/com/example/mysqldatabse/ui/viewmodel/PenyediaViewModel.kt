package com.example.mysqldatabse.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mysqldatabse.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(MahasiswaApplications().container.mahasiswaRepository)
        }
        initializer {
            InsertViewModel(MahasiswaApplications().container.mahasiswaRepository)

        }

        fun CreationExtras.application(): MahasiswaApplications = (
                this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications
                )
    }
}