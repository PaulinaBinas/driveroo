package com.pbinas.driveroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddNewEntryMenuActivity : AppCompatActivity() {
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