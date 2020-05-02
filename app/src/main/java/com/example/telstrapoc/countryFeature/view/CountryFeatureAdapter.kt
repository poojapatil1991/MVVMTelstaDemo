package com.example.telstrapoc.countryFeature.view

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.telstrapoc.R
import com.example.telstrapoc.countryFeature.model.CountryFeature
import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel
import com.example.telstrapoc.countryFeature.viewModel.ResponseViewModel
import com.example.telstrapoc.databinding.CountryFeatureBinding
import com.example.telstrapoc.utils.GlideImageDownloader

class CountryFeatureAdapter (private val mCountryFeatureList : ArrayList<CountryFeatureViewModel>) : RecyclerView.Adapter<CountryFeatureAdapter.ViewHolder>() {

    // glideImageDownloader to download images from server
    lateinit var glideImageDownloader: GlideImageDownloader

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.country_frature_card, viewGroup, false))
        val inflater = LayoutInflater.from(viewGroup.context)
        val countryFeatureBinding: CountryFeatureBinding = DataBindingUtil.inflate(inflater,R.layout.country_frature_card,viewGroup,false)

        return ViewHolder(countryFeatureBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
       /* glideImageDownloader = GlideImageDownloader()
        val mGeneralInfoObj: CountryFeature = mCountryFeatureList[position]
        viewHolder.mTvTitle?.text = mGeneralInfoObj.title
        viewHolder.mTvDescription?.text = mGeneralInfoObj.description
        glideImageDownloader.downloadImage(viewHolder.mIvPhoto,mGeneralInfoObj.imageHref)*/
        val countryFeatureViewModel = mCountryFeatureList[position]
        viewHolder.Bind(countryFeatureViewModel)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mCountryFeatureList.size
    }
    // View holder representing single row in list
    class ViewHolder (val countryFeatureBinding: CountryFeatureBinding) : RecyclerView.ViewHolder(countryFeatureBinding.root) {
        // Holds the TextView that will add each animal to

        fun Bind(countryFeatureViewModel: CountryFeatureViewModel){
            this.countryFeatureBinding.countryFeatureViewModel =countryFeatureViewModel
            countryFeatureBinding.executePendingBindings()
        }

    }
}
