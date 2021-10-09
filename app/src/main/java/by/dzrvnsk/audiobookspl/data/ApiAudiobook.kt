package by.dzrvnsk.audiobookspl.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiAudiobook {

    @GET("audiobooks")
    fun getAudiobooks(): Call<AudiobookResponse>

    companion object {
        private const val BASE_URL = "https://wolnelektury.pl/api/"
        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        fun create(): ApiAudiobook {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
            return retrofit.create()
        }
    }
}