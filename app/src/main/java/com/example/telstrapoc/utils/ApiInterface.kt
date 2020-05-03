package com.example.telstrapoc.utils

import com.example.telstrapoc.countryFeature.viewModel.ResponseViewModel
import retrofit2.http.GET
import rx.Observable

interface ApiInterface  {
    // This API returns the Country features from server
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getCountryFeatureList(): Observable<ResponseViewModel>
}