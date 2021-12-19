package com.pbinas.driveroo.ui.chooseCountry.presenter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.pbinas.driveroo.databinding.ActivityChooseCountryBinding
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryAdapter
import com.pbinas.driveroo.ui.chooseCountry.CountryItem
import com.pbinas.driveroo.util.CountryUtil
import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractor
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryView
import javax.inject.Inject

class ChooseCountryPresenterImpl<V: ChooseCountryView, I: ChooseCountryInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I>(interactor = interactor), ChooseCountryPresenter<V, I> {

    var choosenCountryPosition = -1
    private val countries: List<String> = CountryUtil.getListOfEuropeanCountries()

    override fun setViewValues(binding: ActivityChooseCountryBinding, context: Context) {
        var countryItemsList: List<CountryItem> = extractCountryItems()

        binding.countriesRecyclerView.adapter = ChooseCountryAdapter(countryItemsList, this as BasePresenter<BaseView, BaseInteractor>)
        binding.countriesRecyclerView.layoutManager = GridLayoutManager(context, 3)
        binding.countriesRecyclerView.setHasFixedSize(true)
    }

    override fun updateChosenItem(position: Int) {
        this.choosenCountryPosition = position
        (getView() as ChooseCountryView).enableFurtherButton()
    }

    override fun getNameOfChosenCountry(): String {
        return (countries as List<String>)[choosenCountryPosition]
    }

    private fun extractCountryItems(): List<CountryItem> {
        var countryItemsList = ArrayList<CountryItem>()
        for(country in countries) {
            countryItemsList.add(CountryItem(country, CountryUtil.getEnglishCountryName(country)))
        }
        return countryItemsList
    }
}