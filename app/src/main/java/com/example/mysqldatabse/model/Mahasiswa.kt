package com.example.mysqldatabse.model

import kotlinx.serialization.Serializable

@Serializable
data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,

    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)