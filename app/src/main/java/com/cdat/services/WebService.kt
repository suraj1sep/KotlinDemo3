package com.cdat.services

import com.cdat.services.request.GetVendorNameCityREQ
import com.cdat.services.response.GetInsuranceCompResponse
import com.cdat.services.response.GetVendorNameLogoNearByResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by SAM on 06-11-2018.
 */
interface WebService {
    @GET("api/vendor/GetListOfInsuranceMaster")
    fun getListOfInsuranceMaster(): Call<GetInsuranceCompResponse>

    @POST("api/vendor/GetVendorNameLogoNearBy")
    fun GetVendorNameLogoNearBy(@Body specialityNearByRequest: GetVendorNameCityREQ): Call<GetVendorNameLogoNearByResponse>
}