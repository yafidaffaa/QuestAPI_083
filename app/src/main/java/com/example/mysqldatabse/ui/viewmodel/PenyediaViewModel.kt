package com.example.mysqldatabse.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mysqldatabse.MhsApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(MhsApplications().container.mahasiswaRepository)
        }
        initializer {
            InsertViewModel(MhsApplications().container.mahasiswaRepository)

        }
        initializer {
            DetailViewModel(MhsApplications().container.mahasiswaRepository)

        }
        initializer {
            UpdateViewModel(this.createSavedStateHandle(),MhsApplications().container.mahasiswaRepository)

        }

    }
}

fun CreationExtras.MhsApplications(): MhsApplications = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MhsApplications
        )