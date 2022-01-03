package com.pbinas.driveroo.ui.main.view

import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivityMainBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.main.interactor.MainInteractor
import com.pbinas.driveroo.ui.main.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter<MainView, MainInteractor>
    private lateinit var binding: ActivityMainBinding
    private var name: String? = null
    private var surname: String? = null
    private var company: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        name = intent.extras?.getString("name", null)
        surname = intent.extras?.getString("surname", null)
        company = intent.extras?.getString("company", null)
        presenter.onAttach(this)
        if(name != null && surname != null && company != null) {
            binding.firstNameEditText.setText(name)
            binding.surnameEditText.setText(surname)
            binding.companyEditText.setText(company)
        } else {
            presenter.checkIfAlreadyLoggedIn()
        }
    }

    fun saveNames(view: View) {
        var name = binding.firstNameEditText.text.toString()
        var surname = binding.surnameEditText.text.toString()
        var company = binding.companyEditText.text.toString()

        if(name.isNotBlank() && surname.isNotBlank() && company.isNotBlank()) {
            presenter.registerUser(this, name, surname, company)
        }
    }
}