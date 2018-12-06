package com.dairy.helper

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import com.dairy.services.WebService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by SAM on 05-11-2018.
 */
class Utils {
    companion object {
        fun customMessage(ctx: Context, message: String): Toast {

            val toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            return toast

        }

        fun getWebService(): WebService {

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClient.readTimeout(60, TimeUnit.SECONDS)
            okHttpClient.writeTimeout(60, TimeUnit.SECONDS)

            val WEB_API_BASE_URL = "http://healthquarters.in/Web-Api/"

            return Retrofit.Builder()                                   // Retrofit client.
                    .baseUrl(WEB_API_BASE_URL)                                       // Base domain URL.
                    .addConverterFactory(GsonConverterFactory.create())     // Added converter factory.
                    .client(okHttpClient.build())
                    .build()                                                // Build client.
                    .create(WebService::class.java!!)
        }
    }
}