package com.example.telstrapoc.countryFeature.model

import java.util.*

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