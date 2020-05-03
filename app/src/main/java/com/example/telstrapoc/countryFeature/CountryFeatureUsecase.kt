package com.example.telstrapoc.countryFeature

import com.example.telstrapoc.countryFeature.viewModel.ResponseViewModel
import com.example.telstrapoc.executer.IExecuterThread
import com.example.telstrapoc.executer.UIThread
import com.example.telstrapoc.module.ApiModule
import com.example.telstrapoc.utils.ApiInterface
import com.example.telstrapoc.utils.UseCase
import rx.Observable
/*
Usecase to fetch the data from the API
 */
class CountryFeatureUsecase (executorThreadI : IExecuterThread, postExecuterThread: UIThread)
    : UseCase<ResponseViewModel>(executorThreadI,postExecuterThread) {
    var apiRequest: ApiInterface? =  ApiModule().provideAllApi()

    override fun createObservable(): Observable<ResponseViewModel> {
        return apiRequest!!.getCountryFeatureList()
    }
}