package com.pbinas.driveroo.di

import com.pbinas.driveroo.data.model.DatabaseModule
import com.pbinas.driveroo.data.model.drives.DriveModule
import com.pbinas.driveroo.data.model.user.UserModule
import com.pbinas.driveroo.ui.addNewEntry.AddNewEntryModule
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryActivity
import com.pbinas.driveroo.ui.browse.BrowseModule
import com.pbinas.driveroo.ui.browse.view.BrowseActivity
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryModule
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryActivity
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeActivity
import com.pbinas.driveroo.ui.details.DetailsModule
import com.pbinas.driveroo.ui.details.view.DetailsActivity
import com.pbinas.driveroo.ui.main.MainModule
import com.pbinas.driveroo.ui.main.view.MainActivity
import com.pbinas.driveroo.ui.mainMenu.MainMenuModule
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity
import com.pbinas.driveroo.ui.sendEmail.SendEmailModule
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(DatabaseModule::class), (UserModule::class), (MainModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(AddNewEntryModule::class)])
    abstract fun bindAddNewEntryMenuActivity(): AddNewEntryActivity

    @ContributesAndroidInjector(modules = [(DatabaseModule::class), (DriveModule::class), (BrowseModule::class)])
    abstract fun bindBrowseActivity(): BrowseActivity

    @ContributesAndroidInjector(modules = [(ChooseCountryModule::class)])
    abstract fun bindChooseCountryActivity(): ChooseCountryActivity

    @ContributesAndroidInjector
    abstract fun bindChooseTimeActivity(): ChooseTimeActivity

    @ContributesAndroidInjector(modules = [(DatabaseModule::class), (DriveModule::class), (DetailsModule::class)])
    abstract fun bindDetailsActivity(): DetailsActivity

    @ContributesAndroidInjector(modules = [(DatabaseModule::class), (UserModule::class), (MainMenuModule::class)])
    abstract fun bindMainMenuActivity(): MainMenuActivity

    @ContributesAndroidInjector(modules = [(SendEmailModule::class), (DatabaseModule::class), (DriveModule::class), (UserModule::class)])
    abstract fun bindSendEmailActivity(): SendEmailActivity
}