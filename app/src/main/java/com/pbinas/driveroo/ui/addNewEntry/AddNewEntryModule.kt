package com.pbinas.driveroo.ui.addNewEntry

import com.pbinas.driveroo.ui.addNewEntry.interactor.AddNewEntryInteractor
import com.pbinas.driveroo.ui.addNewEntry.interactor.AddNewEntryInteractorImpl
import com.pbinas.driveroo.ui.addNewEntry.presenter.AddNewEntryPresenter
import com.pbinas.driveroo.ui.addNewEntry.presenter.AddNewEntryPresenterImpl
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryView
import dagger.Module
import dagger.Provides

@Module
class AddNewEntryModule {

    @Provides
    internal fun provideAddNewEntryInteractor(interactor: AddNewEntryInteractorImpl): AddNewEntryInteractor = interactor

    @Provides
    internal fun provideAddNewEntryPresenter(presenter: AddNewEntryPresenterImpl<AddNewEntryView, AddNewEntryInteractor>): AddNewEntryPresenter<AddNewEntryView, AddNewEntryInteractor> = presenter
}