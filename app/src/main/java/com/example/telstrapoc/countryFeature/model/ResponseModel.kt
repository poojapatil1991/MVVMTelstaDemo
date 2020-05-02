package com.example.telstrapoc.countryFeature.model

class ResponseModel{
    var title: String = " "
    var rows: ArrayList<CountryFeature> = ArrayList<CountryFeature>()

    constructor(title: String, rows: ArrayList<CountryFeature>) {
        this.title = title
        this.rows = rows
    }
}