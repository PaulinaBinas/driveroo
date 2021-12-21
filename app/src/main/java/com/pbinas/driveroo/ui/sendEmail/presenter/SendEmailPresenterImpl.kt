package com.pbinas.driveroo.ui.sendEmail.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.databinding.ActivitySendEmailBinding
import com.pbinas.driveroo.ui.base.interactor.BaseInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.base.view.BaseView
import com.pbinas.driveroo.ui.sendEmail.MonthlyEntriesItem
import com.pbinas.driveroo.ui.sendEmail.SendEmailAdapter
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailActivity
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailView
import com.pbinas.driveroo.util.ExcelUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class SendEmailPresenterImpl<V: SendEmailView, I: SendEmailIntercator> @Inject internal
constructor(interactor: I): BasePresenter<V, I> (interactor = interactor), SendEmailPresenter<V, I> {

    private var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun sendData(binding: ActivitySendEmailBinding) {
        var view = getView()
        view?.getChosenMonths()

        interactor?.let {
            var drives: List<Drive>
            var user: User? = null
            var files = ArrayList<String>()
            var run = GlobalScope.launch {
                user = it.getUser()
            }
            var checkedMonths = (binding.monthsRecyclerView.adapter as SendEmailAdapter).checkedMonths
            while(!run.isCompleted) {
                ;
                //wait
            }
            run = GlobalScope.launch {
                for(month in checkedMonths) {
                    drives = it.getDrivesForMonth(month)
                    drives = drives?.sortedWith(compareBy(Drive::date))
                    if (drives != null && user != null) {
                        var file = ExcelUtil.createNewFile(view as SendEmailActivity, drives, user!!)
                        if (file != null) {
                            files.add(file)
                        }
                    }
                }
            }
            while(!run.isCompleted) {
                ;
                //wait
            }
            if(user != null) {
                sendEmail(files, view as SendEmailActivity, user!!)
            }
        }
    }

    override fun setViewValues(binding: ActivitySendEmailBinding, context: Context) {
        interactor?.let {
            var drives: List<Drive>? = null
            var run = GlobalScope.launch {
                drives = it.getAllDrives()
            }
            while(!run.isCompleted) {
                //wait
            }

            var allMonths = ArrayList<String>()
            drives = drives?.reversed()
            if(drives != null) {
                for(drive in drives!!) {
                    var date = LocalDate.parse(drive.date, dateFormatter)
                    var dateString = date.format(DateTimeFormatter.ofPattern("MM/yyyy"))
                    if(!allMonths.contains(dateString)) {
                        allMonths.add(dateString)
                    }
                }
            }
            var result: List<MonthlyEntriesItem> = allMonths.map { MonthlyEntriesItem(it) }

            binding.monthsRecyclerView.adapter = SendEmailAdapter(result, this as BasePresenter<BaseView, BaseInteractor>)
            val verticalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.monthsRecyclerView.layoutManager = verticalLayoutManager
            binding.monthsRecyclerView.setHasFixedSize(false)
            binding.monthsRecyclerView.isNestedScrollingEnabled = true
        }
    }

    private fun sendEmail(files: List<String>, context: Context, user: User) {
        if (files.isNotEmpty()) {
            var excelFiles = ArrayList<Uri>()
            for(file in files) {
                var excelFile = ExcelUtil.readExcelFromStorage(context, file)
                if (excelFile != null) {
                    excelFiles.add(excelFile)
                }
            }
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND_MULTIPLE
                putExtra(Intent.EXTRA_EMAIL, arrayOf("test@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Pliki z danymi od ${user.name} ${user.surname}");
                putParcelableArrayListExtra(Intent.EXTRA_STREAM, excelFiles)
                type = "application/xls"
            }
            context.startActivity(Intent.createChooser(shareIntent, null))
        }
    }
}