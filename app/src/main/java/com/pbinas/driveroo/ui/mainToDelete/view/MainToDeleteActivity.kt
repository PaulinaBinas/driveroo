package com.pbinas.driveroo.ui.mainToDelete.view

import android.os.Bundle
import com.pbinas.driveroo.databinding.ActivityMainBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.mainToDelete.interactor.MainInteractor
import com.pbinas.driveroo.ui.mainToDelete.presenter.MainPresenter
import javax.inject.Inject

class MainToDeleteActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter<MainView, MainInteractor>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.onAttach(this)
    }
}