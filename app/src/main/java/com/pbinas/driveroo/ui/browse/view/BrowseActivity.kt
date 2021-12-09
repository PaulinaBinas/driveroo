package com.pbinas.driveroo.ui.browse.view

import android.os.Bundle
import com.pbinas.driveroo.databinding.ActivityBrowseBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractor
import com.pbinas.driveroo.ui.browse.presenter.BrowsePresenter
import javax.inject.Inject

class BrowseActivity : BaseActivity(), BrowseView {

    @Inject
    lateinit var presenter: BrowsePresenter<BrowseView, BrowseInteractor>
    private lateinit var binding: ActivityBrowseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.setViewValues(binding, this)
    }
}