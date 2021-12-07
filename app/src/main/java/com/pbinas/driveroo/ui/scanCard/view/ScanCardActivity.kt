package com.pbinas.driveroo.ui.scanCard.view

import android.os.Bundle
import com.pbinas.driveroo.databinding.ActivityScanCardBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity

class ScanCardActivity : BaseActivity(), ScanCardView {

    private lateinit var binding: ActivityScanCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var context = this
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}