package com.example.telstrapoc.countryFeature.model

import com.example.telstrapoc.countryFeature.viewModel.CountryFeatureViewModel

class ResponseModel{
    var title: String = " "
    var rows: ArrayList<CountryFeatureViewModel> = ArrayList<CountryFeatureViewModel>()

    constructor(title: String, rows: ArrayList<CountryFeatureViewModel>) {
        this.title = title
        this.rows = rows
    }
}