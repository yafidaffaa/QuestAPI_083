package com.example.mysqldatabse.repository

import com.example.mysqldatabse.model.Mahasiswa
import com.example.mysqldatabse.service.MahasiswaService
import okio.IOException

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaById(nim: String): Mahasiswa?

}

class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
): MahasiswaRepository {
    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mahasiswaApiService.editMahasiswa(nim,mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete mahasiswa. HTTP status code: ${response.code()}")
            }else{
                response.message()
                println(response.message())
            }
        }catch (e:Exception) {
            throw e
        }
    }

    override suspend fun getMahasiswaById(nim: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswaById(nim)
    }

}