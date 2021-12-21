package com.pbinas.driveroo.ui.main.presenter

import android.app.Activity
import android.content.Intent
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.main.interactor.MainInteractor
import com.pbinas.driveroo.ui.main.view.MainActivity
import com.pbinas.driveroo.ui.main.view.MainView
import com.pbinas.driveroo.ui.mainMenu.MainMenuActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenterImpl<V: MainView, I: MainInteractor> @Inject internal constructor(interactor: I): BasePresenter<V, I>(interactor = interactor),
    MainPresenter<V, I> {

    override fun registerUser(context: Activity, firstName: String, surname: String) {
        var newUser = User(firstName, surname)

        interactor?.let {
            GlobalScope.launch {
                it.saveUser(newUser)
            }
        }

        goToMainMenu(context)
    }

    private fun goToMainMenu(context: Activity) {
        var intent = Intent(context, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
        context.finish()
    }

    override fun checkIfAlreadyLoggedIn() {
        interactor?.let {
            var user: User? = null
            var run = GlobalScope.launch {
                user = it.getUser()
            }
            while (!run.isCompleted) {;}
            if(user != null) {
                goToMainMenu(getView() as MainActivity)
            }
        }
    }

}