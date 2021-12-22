package com.pbinas.driveroo.ui.confirmDeletion

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.details.view.DetailsActivity

class ConfirmDeletionActivity : AppCompatActivity() {
    var id = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_deletion)
        id = intent.extras?.getInt("id", -1) ?: -1
    }

    fun cancel(view: View) {
        super.onBackPressed()
    }

    fun delete(view: View) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("id", id)
        intent.putExtra("delete", "yes")
        startActivity(intent)
        this.finish()
    }
}