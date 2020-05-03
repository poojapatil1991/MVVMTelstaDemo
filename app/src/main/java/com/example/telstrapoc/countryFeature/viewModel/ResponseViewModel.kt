package com.example.telstrapoc.countryFeature.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.telstrapoc.countryFeature.CountryFeatureUsecase
import com.example.telstrapoc.countryFeature.model.ResponseModel
import com.example.telstrapoc.executer.IExecuterThread
import com.example.telstrapoc.executer.UIThread
import com.example.telstrapoc.module.ThreadModule
import rx.Subscriber


class ResponseViewModel : ViewModel{

    var title: String = " "
    var rows: ArrayList<CountryFeatureViewModel> = ArrayList<CountryFeatureViewModel>()
   // lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    constructor() : super()

    constructor(responseModel : ResponseModel) : super() {
        this.title = responseModel.title
        this.rows = responseModel.rows
    }

    var isLoading= MutableLiveData<Boolean>()
    var titleLiveData = MutableLiveData<String>()
    var rowsLiveData = MutableLiveData<ArrayList<CountryFeatureViewModel>>()
    val uiThread: UIThread = ThreadModule().providePostExecutionThread()
    val executorThread: IExecuterThread = ThreadModule().provideExecutorThread()

    val countryFeatureUsecase: CountryFeatureUsecase = CountryFeatureUsecase(executorThread,uiThread)
    var countryFeatureSubscriber: CountryFeatureSubscriber = CountryFeatureSubscriber()

    fun getCountryFeature() : MutableLiveData<ArrayList<CountryFeatureViewModel>>{
        isLoading!!.value = true
        //mSwipeRefreshLayout.isRefreshing = true
        countryFeatureUsecase.execute(countryFeatureSubscriber)
        return rowsLiveData
    }

    /*
   Subscriber to show image list on UI
   as soon as image list downloads from server it get notifies and show list of images on UI
    */
    inner class CountryFeatureSubscriber : Subscriber<ResponseViewModel>() {

        override fun onCompleted() {}
        override fun onError(e: Throwable) {
            isLoading!!.value = false
            //mSwipeRefreshLayout.isRefreshing = false
            Log.e("TelstraPoc",e.toString())
        }
        override fun onNext(resDetails: ResponseViewModel) {
            rowsLiveData.value = resDetails.rows
            isLoading!!.value = false
           // mSwipeRefreshLayout.isRefreshing = false
        }
    }

     override fun onCleared() {
        super.onCleared()
    }


}
