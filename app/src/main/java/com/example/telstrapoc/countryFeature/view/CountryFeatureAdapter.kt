package com.example.telstrapoc.countryFeature.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.telstrapoc.R
import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel
import com.example.telstrapoc.databinding.CountryFeatureBinding

/*
Adapter for country feature recycler view
 */

class CountryFeatureAdapter(private val mCountryFeatureList: ArrayList<CountryFeatureViewModel>?) :
    RecyclerView.Adapter<CountryFeatureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val countryFeatureBinding: CountryFeatureBinding =
            DataBindingUtil.inflate(inflater, R.layout.country_frature_card, viewGroup, false)

        return ViewHolder(countryFeatureBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val countryFeatureViewModel = mCountryFeatureList!![position]
        viewHolder.bind(countryFeatureViewModel)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mCountryFeatureList!!.size
    }

    // View holder representing single row in list
    class ViewHolder(private val countryFeatureBinding: CountryFeatureBinding) :
        RecyclerView.ViewHolder(countryFeatureBinding.root) {

        fun bind(countryFeatureViewModel: CountryFeatureViewModel) {
            this.countryFeatureBinding.countryFeatureViewModel = countryFeatureViewModel
            countryFeatureBinding.executePendingBindings()
        }

    }
}
