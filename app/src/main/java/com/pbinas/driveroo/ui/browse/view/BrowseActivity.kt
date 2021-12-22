package com.pbinas.driveroo.ui.browse.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivityBrowseBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractor
import com.pbinas.driveroo.ui.browse.presenter.BrowsePresenter
import com.pbinas.driveroo.ui.details.view.DetailsActivity
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
        playAnimation()
        presenter.onAttach(this)
        presenter.setViewValues(binding, this)
        stopAnimation()
    }

    override fun openDetails(id: Int) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("edit", true)
        startActivity(intent)
    }

    override fun playAnimation() {
        //binding.loading.visibility = View.VISIBLE
    }

    override fun stopAnimation() {
        //binding.loading.visibility = View.INVISIBLE
    }


}