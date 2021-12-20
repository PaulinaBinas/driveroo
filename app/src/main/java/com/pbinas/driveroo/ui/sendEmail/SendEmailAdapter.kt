package com.pbinas.driveroo.ui.sendEmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView

class SendEmailAdapter(private val monthsList: List<MonthlyEntriesItem>, private var viewPresenter:
BasePresenter<BaseView, BaseInteractor>): RecyclerView.Adapter<SendEmailAdapter.SendEmailViewHolder>() {

    var parent: ViewGroup? = null
    var checkedMonths = ArrayList<String>()

    class SendEmailViewHolder(sendEmailView: View): RecyclerView.ViewHolder(sendEmailView) {
        val monthAndYearTextView: TextView = sendEmailView.findViewById(R.id.monthAndYearTextView)
        val checkBox: CheckBox = sendEmailView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SendEmailViewHolder {
        this.parent = parent
        val sendEmailView = LayoutInflater.from(parent.context).inflate(R.layout.month, parent, false)
        return SendEmailViewHolder(sendEmailView)
    }

    override fun onBindViewHolder(holder: SendEmailViewHolder, position: Int) {
        val currentEntry = monthsList[position]
        holder.monthAndYearTextView.text = currentEntry.monthAndYear
        holder.checkBox.setOnClickListener {
            if(holder.checkBox.isChecked) {
                checkedMonths.add(currentEntry.monthAndYear)
            } else {
                checkedMonths.remove(currentEntry.monthAndYear)
            }
        }
    }

    override fun getItemCount() = monthsList.size
}