package com.pbinas.driveroo.ui.chooseCountry.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivityChooseCountryBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryAdapter
import com.pbinas.driveroo.ui.chooseCountry.CountryUtil
import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractor
import com.pbinas.driveroo.ui.chooseCountry.presenter.ChooseCountryPresenter
import com.pbinas.driveroo.ui.details.view.DetailsActivity
import javax.inject.Inject

class ChooseCountryActivity : BaseActivity(), ChooseCountryView {
    @Inject
    lateinit var presenter: ChooseCountryPresenter<ChooseCountryView, ChooseCountryInteractor>
    private lateinit var binding: ActivityChooseCountryBinding
    var type = ""
    var date = ""
    var time = ""
    private var country: String? = null
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        id = intent.extras?.getInt("id", -1)
        binding = ActivityChooseCountryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.onAttach(this)
        presenter.setViewValues(binding, this)
        if(id != null && id!! > -1) {
            country = intent.extras?.getString("country") ?: ""
            var indexOfCountry = CountryUtil.getListOfEuropeanCountries().indexOf(country)
            presenter.updateChosenItem(indexOfCountry)
            (binding.countriesRecyclerView.adapter as ChooseCountryAdapter).clickedItem = indexOfCountry
            (binding.countriesRecyclerView.adapter as ChooseCountryAdapter).notifyDataSetChanged()
        }

    }

    fun goFurther(view: View) {
        var intent = Intent(this, DetailsActivity::class.java)
        if(id != null && id!! > -1) {
            intent.putExtra("id", id)
        }
        intent.putExtra("type", type)
        intent.putExtra("date", date)
        intent.putExtra("time", time)
        intent.putExtra("country", getCountry())
        startActivity(intent)
    }

    private fun getCountry(): String {
        return presenter.getNameOfChosenCountry()
    }

    override fun enableFurtherButton() {
        binding.buttonFurther.isEnabled = true
    }
}