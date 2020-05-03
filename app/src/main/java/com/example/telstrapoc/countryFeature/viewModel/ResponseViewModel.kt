package com.example.telstrapoc.countryFeature.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telstrapoc.countryFeature.CountryFeatureUsecase
import com.example.telstrapoc.countryFeature.model.ResponseModel
import com.example.telstrapoc.executer.IExecuterThread
import com.example.telstrapoc.executer.UIThread
import com.example.telstrapoc.module.ThreadModule
import com.example.telstrapoc.utils.NetworkConnection
import rx.Subscriber


class ResponseViewModel : ViewModel{

    var title: String = " "
    var rows: ArrayList<CountryFeatureViewModel> = ArrayList<CountryFeatureViewModel>()
    constructor() : super()

    constructor(responseModel : ResponseModel) : super() {
        this.title = responseModel.title
        this.rows = responseModel.rows
    }

    var loadingError= MutableLiveData<Boolean>()
    var loading= MutableLiveData<Boolean>()
    var titleLiveData = MutableLiveData<String>()
    var rowsLiveData = MutableLiveData<ArrayList<CountryFeatureViewModel>>()
    val uiThread: UIThread = ThreadModule().providePostExecutionThread()
    val executorThread: IExecuterThread = ThreadModule().provideExecutorThread()

    val countryFeatureUsecase: CountryFeatureUsecase = CountryFeatureUsecase(executorThread,uiThread)

    fun getCountryFeature() : MutableLiveData<ArrayList<CountryFeatureViewModel>>{
        if (NetworkConnection.isNetworkConnected()) {
            loadingError!!.value = false
            loading!!.value = true
            countryFeatureUsecase.execute(CountryFeatureSubscriber())
        }else{
            loading!!.value = false
            loadingError!!.value = true
        }

        return rowsLiveData
    }

    /*
   Subscriber to show image list on UI
   as soon as image list downloads from server it get notifies and show list of images on UI
    */
    inner class CountryFeatureSubscriber : Subscriber<ResponseViewModel>() {

        override fun onCompleted() {}
        override fun onError(e: Throwable) {
            loading!!.value = false
            loadingError!!.value = true
            Log.e("TelstraPoc",e.toString())
        }
        override fun onNext(resDetails: ResponseViewModel) {
            rowsLiveData.value = resDetails.rows
            loadingError!!.value = false
            loading!!.value = false
        }
    }
}
