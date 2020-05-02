package com.example.telstrapoc.countryFeature.view

import android.os.Bundle
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
import kotlinx.android.synthetic.main.activity_country_feature.*


class CountryFeatureActivity : AppCompatActivity(),LifecycleOwner,SwipeRefreshLayout.OnRefreshListener {

    private var rvCountryFeature : RecyclerView ?= null
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    //private var responseViewModel : ResponseViewModel = ResponseViewModel()
    private var countryFeatureAdapter : CountryFeatureAdapter ? = null
    private var context : CountryFeatureActivity ?= null
    private var responseViewModel: ResponseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(R.layout.activity_country_feature)
        setSupportActionBar(toolbar)

        rvCountryFeature = findViewById(R.id.rv_country_feature)as RecyclerView
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        mSwipeRefreshLayout.setOnRefreshListener(this)

        responseViewModel  = ViewModelProviders.of(this).get(ResponseViewModel::class.java)
        loadDatainRecyclerView()
    }

    fun loadDatainRecyclerView(){
        responseViewModel!!.getCountryFeature().observe(this, Observer{
                it:ArrayList<CountryFeatureViewModel>->countryFeatureAdapter= CountryFeatureAdapter(it)
            rvCountryFeature!!.setLayoutManager(LinearLayoutManager(context))
            rvCountryFeature!!.setAdapter(countryFeatureAdapter)
        })
    }

    override fun onRefresh() {
        mSwipeRefreshLayout.isRefreshing=false
        loadDatainRecyclerView()
    }
}
