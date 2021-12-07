package com.pbinas.driveroo.di

import com.pbinas.driveroo.ui.addNewEntry.AddNewEntryMenuActivity
import com.pbinas.driveroo.ui.browse.BrowseActivity
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryActivity
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeActivity
import com.pbinas.driveroo.ui.details.DetailsActivity
import com.pbinas.driveroo.ui.main.view.MainActivity
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity
import com.pbinas.driveroo.ui.mainToDelete.MainModule
import com.pbinas.driveroo.ui.mainToDelete.view.MainToDeleteActivity
import com.pbinas.driveroo.ui.scanCard.ScanCardModule
import com.pbinas.driveroo.ui.scanCard.view.ScanCardActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindMainToDeleteActivity(): MainToDeleteActivity

    @ContributesAndroidInjector(modules = [(ScanCardModule::class)])
    abstract fun bindScanCardActivity(): ScanCardActivity



    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindAddNewEntryMenuActivity(): AddNewEntryMenuActivity

    @ContributesAndroidInjector
    abstract fun bindBrowseActivity(): BrowseActivity

    @ContributesAndroidInjector
    abstract fun bindChooseCountryActivity(): ChooseCountryActivity

    @ContributesAndroidInjector
    abstract fun bindChooseTimeActivity(): ChooseTimeActivity

    @ContributesAndroidInjector
    abstract fun bindDetailsActivity(): DetailsActivity

    @ContributesAndroidInjector
    abstract fun bindMainMenuActivity(): MainMenuActivity
}