package com.pbinas.driveroo.ui.chooseDelegationType.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.pbinas.driveroo.databinding.ActivityChooseDelegationTypeBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractor
import com.pbinas.driveroo.ui.chooseDelegationType.presenter.ChooseDelegationTypePresenter
import com.pbinas.driveroo.ui.details.view.DetailsActivity
import javax.inject.Inject

class ChooseDelegationTypeActivity : BaseActivity(), ChooseDelegationTypeView {

    @Inject
    lateinit var presenter: ChooseDelegationTypePresenter<ChooseDelegationTypeView, ChooseDelegationTypeInteractor>
    private lateinit var binding: ActivityChooseDelegationTypeBinding
    private var chosenType: String? = null
    private var type = ""
    private var date = ""
    private var time = ""
    private var country = ""
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        country = intent.extras?.getString("country") ?: ""
        id = intent.extras?.getInt("id", -1)
        binding = ActivityChooseDelegationTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.onAttach(this)
    }

    fun onRadioButtonClicked(view: View) {
        var checkedButton = view as RadioButton
        chosenType = checkedButton.text.toString()
    }

    fun goFurther(view: View) {
        var intent = Intent(this, DetailsActivity::class.java)
        if(id != null && id!! > -1) {
            intent.putExtra("id", id)
        }
        intent.putExtra("type", type)
        intent.putExtra("date", date)
        intent.putExtra("time", time)
        intent.putExtra("country", country)
        if(chosenType != null) {
            intent.putExtra("chosenType", chosenType)
        }
        startActivity(intent)
    }
}