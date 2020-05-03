package com.example.telstrapoc.countryFeature.model
/*
Model to retrive Country Features from API
 */
class CountryFeature  {
    var title: String = ""
    var description: String = ""
    var imageHref : String = ""

    constructor(title: String, description: String, imageHref: String) {
        this.title = title
        this.description = description
        this.imageHref = imageHref
    }
}