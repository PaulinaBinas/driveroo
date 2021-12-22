package com.pbinas.driveroo.ui.mainMenu.presenter

import android.app.Activity
import android.content.Intent
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.main.view.MainActivity
import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainMenuPresenterImpl<V: MainMenuView, I: MainMenuInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I>(interactor = interactor), MainMenuPresenter<V, I>{

    private var user: User? = null

    override fun setTitleText() {
        interactor?.let {
            GlobalScope.launch {
                user = it.getUser()
                user?.let { u -> (getView() as MainMenuView).setTitle(u.name, u.surname) }
            }
        }
    }

    override fun changeName(context: Activity) {
        var intent = Intent(context, MainActivity::class.java)
        if (user != null) {
            intent.putExtra("name", user!!.name)
            intent.putExtra("surname", user!!.surname)
        }
        context.startActivity(intent)
    }
}