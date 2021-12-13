package com.pbinas.driveroo.ui.browse.presenter

import android.content.Context
import com.pbinas.driveroo.databinding.ActivityBrowseBinding
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractor
import com.pbinas.driveroo.ui.browse.view.BrowseView

interface BrowsePresenter<V: BrowseView, I: BrowseInteractor>: Presenter<V, I> {

    fun setViewValues(binding: ActivityBrowseBinding, context: Context)

    fun openDetails(id: Int)
}