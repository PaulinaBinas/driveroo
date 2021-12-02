package com.pbinas.driveroo.ui.addNewEntry

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.util.RideType

class AddNewEntryMenuActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_entry_menu)
    }

    fun goFurtherLoading(view: View) {
        goFurther(RideType.LOADING)
    }

    fun goFurtherUnloading(view: View) {
        goFurther(RideType.UNLOADING)
    }

    private fun goFurther(type: RideType) {
        var intent = Intent(this, ChooseTimeActivity::class.java)
        startActivity(intent)
    }
}