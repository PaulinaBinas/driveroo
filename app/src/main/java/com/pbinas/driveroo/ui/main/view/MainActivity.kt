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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun saveNames(view: View) {
        var name = binding.firstNameEditText.text.toString()
        var surname = binding.surnameEditText.text.toString()

        if(name.isNotBlank() && surname.isNotBlank()) {
            presenter.registerUser(this, name, surname)
        }
    }
}