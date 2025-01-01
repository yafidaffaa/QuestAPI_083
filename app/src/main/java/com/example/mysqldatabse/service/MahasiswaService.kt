package com.example.mysqldatabse.service

import com.example.mysqldatabse.model.Mahasiswa
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import retrofit2.Response

interface MahasiswaService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("bacamahasiswa.php")
    suspend fun getMahasiswa(): List<Mahasiswa>

    @GET("baca1mahasiswa.php/{nim}")
    suspend fun getMahasiswaById(@Query("nim") nim: String): Mahasiswa

    @POST("insertmahasiswa.php")
    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa): Mahasiswa

    @PUT("editmahasiswa.php/{nim}")
    suspend fun editMahasiswa(@Query("nim") nim: String, @Body mahasiswa: Mahasiswa): Mahasiswa

    @DELETE("deletemahasiswa.php/{nim}")
    suspend fun deleteMahasiswa(@Query("nim") nim: String): Response<Void>

}