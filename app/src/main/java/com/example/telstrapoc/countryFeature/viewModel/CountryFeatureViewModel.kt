package com.example.telstrapoc.countryFeature.viewModel

import androidx.lifecycle.ViewModel
import com.example.telstrapoc.countryFeature.model.CountryFeature
/*
View model for the Country feature model
 */
class CountryFeatureViewModel : ViewModel {

    var title: String = ""
    var description: String = ""
    var imageHref : String = ""

    constructor() : super()

    constructor(countryFeature: CountryFeature) : super() {
        this.title = countryFeature.title
        this.description = countryFeature.description
        this.imageHref = countryFeature.imageHref
    }
}