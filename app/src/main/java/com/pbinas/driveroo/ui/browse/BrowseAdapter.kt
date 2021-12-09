package com.pbinas.driveroo.ui.browse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView

class BrowseAdapter(private val drivesList: List<DriveItem>, private var viewPresenter:
BasePresenter<BaseView, BaseInteractor>): RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder>() {

    var parent: ViewGroup? = null
    var clickedItem = -1

    class BrowseViewHolder(browseView: View): RecyclerView.ViewHolder(browseView) {
        val dateTextView: TextView = browseView.findViewById(R.id.dateTextView)
        val view = browseView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        this.parent = parent
        val browseView = LayoutInflater.from(parent.context).inflate(R.layout.drive, parent, false)
        return BrowseViewHolder(browseView)
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        val currentDrive = drivesList[position]

        holder.dateTextView.text = currentDrive.date + " " + currentDrive.time
    }

    override fun getItemCount() = drivesList.size
}