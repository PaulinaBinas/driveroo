package com.pbinas.driveroo.ui.chooseDelegationType.view

import android.os.Bundle
import com.pbinas.driveroo.databinding.ActivityChooseDelegationTypeBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractor
import com.pbinas.driveroo.ui.chooseDelegationType.presenter.ChooseDelegationTypePresenter
import javax.inject.Inject

class ChooseDelegationTypeActivity : BaseActivity(), ChooseDelegationTypeView {

    @Inject
    lateinit var presenter: ChooseDelegationTypePresenter<ChooseDelegationTypeView, ChooseDelegationTypeInteractor>
    private lateinit var binding: ActivityChooseDelegationTypeBinding
    private var choosenType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseDelegationTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.onAttach(this)
    }
}