package com.pbinas.driveroo.ui.mainMenu.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivityMainMenuBinding
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.browse.view.BrowseActivity
import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.mainMenu.presenter.MainMenuPresenter
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailActivity
import javax.inject.Inject


class MainMenuActivity : BaseActivity(), MainMenuView {
    @Inject
    lateinit var presenter: MainMenuPresenter<MainMenuView, MainMenuInteractor>
    lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        presenter.onAttach(this)
        presenter.setTitleText()
        binding.title.setOnClickListener {
            presenter.changeName(this)
        }
    }

    fun browseEntries(view: View) {
        var intent = Intent(this, BrowseActivity::class.java)
        startActivity(intent)
    }

    fun addRide(view: View) {
        var intent = Intent(this, AddNewEntryActivity::class.java)
        startActivity(intent)
    }

    fun sendEmail(view: View) {
        var intent = Intent(this, SendEmailActivity::class.java)
        startActivity(intent)
    }

    override fun setTitle(firstName: String, surname: String) {
        binding.title.text = "Witaj, $firstName $surname!"
        binding.title.paint?.isUnderlineText = true
    }
}