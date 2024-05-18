package com.oliveiralabs.estudosmadskills.service

import com.oliveiralabs.estudosmadskills.model.Kit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface KitService {
    @GET("index.json")
    suspend fun getKits(): List<Kit>

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/oliveiralabs/megadrum-kits/master/"

        fun create(): KitService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(KitService::class.java)
        }
    }
}
