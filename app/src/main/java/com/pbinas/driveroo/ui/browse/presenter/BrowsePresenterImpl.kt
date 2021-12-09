package com.pbinas.driveroo.ui.browse.presenter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.databinding.ActivityBrowseBinding
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView
import com.pbinas.driveroo.ui.browse.BrowseAdapter
import com.pbinas.driveroo.ui.browse.DriveItem
import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractor
import com.pbinas.driveroo.ui.browse.view.BrowseView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class BrowsePresenterImpl<V: BrowseView, I: BrowseInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I>(interactor = interactor), BrowsePresenter<V, I> {

    override fun setViewValues(binding: ActivityBrowseBinding, context: Context) {
        var drives: List<Drive> = ArrayList()
        interactor?.let {
            GlobalScope.launch {
                drives = it.getAllDrives()
            }
        }

        var driveItemsList: List<DriveItem> = extractDriveItems(drives)

        binding.drivesRecyclerView.adapter = BrowseAdapter(driveItemsList, this as BasePresenter<BaseView, BaseInteractor>)
        val verticalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.drivesRecyclerView.layoutManager = verticalLayoutManager
        binding.drivesRecyclerView.setHasFixedSize(true)
    }

    private fun extractDriveItems(drives: List<Drive>): List<DriveItem> {
        var result: List<DriveItem> = ArrayList()
        for (drive in drives) {
            result += DriveItem(drive.date, drive.time)
        }
        return result
    }
}