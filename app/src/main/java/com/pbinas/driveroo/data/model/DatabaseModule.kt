package com.pbinas.driveroo.data.model

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pbinas.driveroo.data.model.drives.DriveDao
import com.pbinas.driveroo.data.model.user.UserDao
import dagger.Module
import dagger.Provides


@Module
class DatabaseModule {

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE User ADD COLUMN company TEXT NOT NULL DEFAULT ''")
        }
    }

    @Provides
    fun provideDriveDao(db: ApplicationDatabase): DriveDao = db.driveDao()

    @Provides
    fun provideUserDao(db: ApplicationDatabase): UserDao = db.userDao()

    @Provides
    fun provideDatabase(context: Application): ApplicationDatabase = Room
        .databaseBuilder(context, ApplicationDatabase::class.java, "driverooApp.db")
        .createFromAsset("database/driveroo.db")
        .addMigrations(MIGRATION_1_2)
        .build()
}