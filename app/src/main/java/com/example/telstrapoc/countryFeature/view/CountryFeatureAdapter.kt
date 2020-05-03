package com.example.telstrapoc.countryFeature.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.telstrapoc.R
import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel
import com.example.telstrapoc.databinding.CountryFeatureBinding
import com.example.telstrapoc.utils.GlideImageDownloader
/*
Adapter for country feature recycler view
 */

class CountryFeatureAdapter (private val mCountryFeatureList : ArrayList<CountryFeatureViewModel>) : RecyclerView.Adapter<CountryFeatureAdapter.ViewHolder>() {

    // glideImageDownloader to download images from server
    lateinit var glideImageDownloader: GlideImageDownloader

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val countryFeatureBinding: CountryFeatureBinding = DataBindingUtil.inflate(inflater,R.layout.country_frature_card,viewGroup,false)

        return ViewHolder(countryFeatureBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val countryFeatureViewModel = mCountryFeatureList[position]
        viewHolder.Bind(countryFeatureViewModel)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mCountryFeatureList.size
    }
    // View holder representing single row in list
    class ViewHolder (val countryFeatureBinding: CountryFeatureBinding) : RecyclerView.ViewHolder(countryFeatureBinding.root) {

        fun Bind(countryFeatureViewModel: CountryFeatureViewModel){
            this.countryFeatureBinding.countryFeatureViewModel =countryFeatureViewModel
            countryFeatureBinding.executePendingBindings()
        }

    }
}
