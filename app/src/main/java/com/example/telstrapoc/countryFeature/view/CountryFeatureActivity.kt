package com.example.telstrapoc.countryFeature.view

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.telstrapoc.R
import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel
import com.example.telstrapoc.countryFeature.viewModel.ResponseViewModel
import com.example.telstrapoc.utils.CountryFeatureApplication
import kotlinx.android.synthetic.main.activity_country_feature.*
/*
Launcher Activity, Main activity to show country feature data on activity.
 */

class CountryFeatureActivity : AppCompatActivity(),LifecycleOwner,SwipeRefreshLayout.OnRefreshListener {

    private var rvCountryFeature : RecyclerView ?= null
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private var countryFeatureAdapter : CountryFeatureAdapter ? = null
    private var context : CountryFeatureActivity ?= null
    private var responseViewModel: ResponseViewModel? = null
    lateinit var mDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        setContentView(R.layout.activity_country_feature)
        setSupportActionBar(toolbar)

        rvCountryFeature = findViewById(R.id.rv_country_feature)as RecyclerView
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        mSwipeRefreshLayout.setOnRefreshListener(this)

        mDialog = Dialog(this)
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)

        responseViewModel  = ViewModelProviders.of(this).get(ResponseViewModel::class.java)
        loadDatainRecyclerView()

        responseViewModel!!.loadingError.observe(this, Observer { t:Boolean->showError(t)})

        responseViewModel!!.loading.observe(this, Observer { t:Boolean->showLoading(t)})
        responseViewModel!!.titleLiveData.observe(this, Observer { t:String->showTitle(t)})
    }

    //Function to show country feature in recycler view
    fun loadDatainRecyclerView(){
        responseViewModel!!.getCountryFeature().observe(this, Observer{
                it:ArrayList<CountryFeatureViewModel>->countryFeatureAdapter= CountryFeatureAdapter(it)
            rvCountryFeature!!.setLayoutManager(LinearLayoutManager(context))
            rvCountryFeature!!.setAdapter(countryFeatureAdapter)
        })
    }

    override fun onRefresh() {
        mSwipeRefreshLayout.isRefreshing=false
        responseViewModel!!.getCountryFeature()
    }
    fun showError(showError : Boolean){
        if(showError) {
            Toast.makeText(CountryFeatureApplication.context, "Please try again!!! Check internet connection.", Toast.LENGTH_SHORT)
                .show()
        }
    }
    fun showProgressDialog() {
        mDialog.setContentView(R.layout.progress_dialog_layout)
        mDialog.show()
    }

    fun showLoading(isLoading: Boolean) {
        if(isLoading) {
            if (!mDialog.isShowing) {
                showProgressDialog()
            }
        }else{
            hideLoading()
        }
    }
    fun hideLoading() {
        if(mDialog.isShowing){
            mDialog.hide()
        }
    }
    //Function to show title in action bar
    fun showTitle(title:String){
        supportActionBar!!.title = title
    }

}
