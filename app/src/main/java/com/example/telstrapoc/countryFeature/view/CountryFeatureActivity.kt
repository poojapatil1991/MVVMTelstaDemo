package com.example.telstrapoc.countryFeature.view

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.telstrapoc.R
import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel
import com.example.telstrapoc.countryFeature.viewModel.ResponseViewModel
import com.example.telstrapoc.utils.CountryFeatureApplication
import com.example.telstrapoc.utils.NetworkConnection
import kotlinx.android.synthetic.main.activity_country_feature.*
import kotlinx.android.synthetic.main.content_country_feature.*

/*
Launcher Activity, Main activity to show country feature data on activity.
 */

class CountryFeatureActivity : AppCompatActivity(), LifecycleOwner,
    SwipeRefreshLayout.OnRefreshListener {

    private var countryFeatureAdapter: CountryFeatureAdapter =
        CountryFeatureAdapter(ArrayList<CountryFeatureViewModel>())
    private var context: CountryFeatureActivity? = null
    private var responseViewModel: ResponseViewModel? = null
    private lateinit var mDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        setContentView(R.layout.activity_country_feature)
        setSupportActionBar(toolbar)
        swipe_refresh.setOnRefreshListener(this)

        mDialog = Dialog(this)
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)

        responseViewModel = ViewModelProviders.of(this).get(ResponseViewModel::class.java)
        rv_country_feature!!.layoutManager = LinearLayoutManager(context)
        rv_country_feature!!.adapter = countryFeatureAdapter

        responseViewModel!!.loadingError.observe(
            this,
            Observer { t: Boolean -> showError(t, "Please try again!!!") })

        responseViewModel!!.loading.observe(this, Observer { t: Boolean -> showLoading(t) })
        responseViewModel!!.titleLiveData.observe(this, Observer { t: String -> showTitle(t) })
        responseViewModel!!.rowsLiveData
            .observe(this, Observer { it: ArrayList<CountryFeatureViewModel> ->
                countryFeatureAdapter.setArrayList(it)
            })
        loadDataInRecyclerView()
    }

    //Function to show country feature in recycler view
    private fun loadDataInRecyclerView() {
        if (NetworkConnection.isNetworkConnected()) {
            responseViewModel!!.getCountryFeature()
        } else {
            showError(true, "Check your internet connection. Please try again!!!")
        }
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = false
        loadDataInRecyclerView()
    }

    private fun showError(showError: Boolean, message: String) {
        if (showError) {
            Toast.makeText(
                CountryFeatureApplication.context,
                message,
                Toast.LENGTH_SHORT
            )
                .show()

        }
    }

    private fun showProgressDialog() {
        mDialog.setContentView(R.layout.progress_dialog_layout)
        mDialog.show()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            showProgressDialog()
        } else {
            hideLoading()
        }
    }

    private fun hideLoading() {
        if (mDialog.isShowing) {
            mDialog.hide()
        }
    }

    //Function to show title in action bar
    private fun showTitle(title: String) {
        supportActionBar!!.title = title
    }
}
