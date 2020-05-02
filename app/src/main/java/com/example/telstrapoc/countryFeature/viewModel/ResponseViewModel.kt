package com.example.telstrapoc.countryFeature.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telstrapoc.countryFeature.model.CountryFeature
import com.example.telstrapoc.countryFeature.model.ResponseModel


class ResponseViewModel : ViewModel{

    var title: String = " "
    var rows: ArrayList<CountryFeature> = ArrayList<CountryFeature>()

    constructor() : super()

    constructor(responseModel : ResponseModel) : super() {
        this.title = responseModel.title
        this.rows = responseModel.rows
    }

    var titleLiveData = MutableLiveData<String>()
    var rowsLiveData = MutableLiveData<ArrayList<CountryFeatureViewModel>>()

    fun getCountryFeature() : MutableLiveData<ArrayList<CountryFeatureViewModel>>{

        val  feature1 = CountryFeatureViewModel(CountryFeature("Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

        val  feature2 = CountryFeatureViewModel(CountryFeature("Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

        val  feature3 = CountryFeatureViewModel(CountryFeature("Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

        var countryFeatureList : ArrayList<CountryFeatureViewModel> = ArrayList<CountryFeatureViewModel>()

        countryFeatureList.add(feature1)
        countryFeatureList.add(feature2)
        countryFeatureList.add(feature3)
        rowsLiveData.value = countryFeatureList

        return rowsLiveData
    }


    /*var responseLiveData = MutableLiveData<ResponseViewModel>()


    fun getcountryFeature():MutableLiveData<ResponseViewModel>{

       val  feature1 = CountryFeature("Beavers",
           "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
           "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg")

        val  feature2 = CountryFeature("Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg")

        val  feature3 = CountryFeature("Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg")

        var countryFeatureList : ArrayList<CountryFeature> = ArrayList<CountryFeature>()

        countryFeatureList.add(feature1)
        countryFeatureList.add(feature2)
        countryFeatureList.add(feature3)

        val resModel : ResponseModel = ResponseModel("About Canada",countryFeatureList)

        responseLiveData.value = ResponseViewModel(resModel)

        return responseLiveData

    }*/
}
