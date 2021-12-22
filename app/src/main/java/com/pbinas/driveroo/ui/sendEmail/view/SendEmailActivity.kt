package com.pbinas.driveroo.ui.sendEmail.view

import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivitySendEmailBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.presenter.SendEmailPresenter
import javax.inject.Inject

class SendEmailActivity : BaseActivity(), SendEmailView {

    @Inject
    lateinit var presenter: SendEmailPresenter<SendEmailView, SendEmailIntercator>
    private lateinit var binding: ActivitySendEmailBinding
    private var chosenMonths = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.onAttach(this)
        presenter.setViewValues(binding, this)
        stopAnimation()
    }

    fun sendData(view: View) {
        playAnimation()
        presenter.sendData(binding)
        stopAnimation()
    }

    override fun getChosenMonths(): List<String> {
        return this.chosenMonths
    }

    override fun playAnimation() {
        //binding.loading.visibility = View.VISIBLE
    }

    override fun stopAnimation() {
        //binding.loading.visibility = View.GONE
    }
}