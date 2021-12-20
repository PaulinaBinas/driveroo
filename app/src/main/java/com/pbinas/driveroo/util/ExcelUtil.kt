package com.pbinas.driveroo.util

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import com.pbinas.driveroo.BuildConfig
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.user.User
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Sheet
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ExcelUtil {

    companion object {

        private var nameAndSurname = "Imię i nazwisko"
        private var country = "Państwo"
        private var date = "Data"
        private var time = "Godzina"
        private var rideType = "Typ przejazdu"
        private var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        fun createNewFile(context: Context, drives: List<Drive>, user: User): String? {
            if(drives.isNotEmpty()) {
                val workbook = HSSFWorkbook()
                val sheet: Sheet = workbook.createSheet()

                createHeadings(sheet, user)
                createContent(sheet, drives)

                var date = LocalDate.parse(drives.firstOrNull()?.date, dateFormatter)
                var dateText = date.format(DateTimeFormatter.ofPattern("yyyy_MM"))
                var filename = "${user.name}_${user.surname}_$dateText.xls"
                storeExcelInStorage(context, filename, workbook)

                return filename
            }
            return null
        }

        private fun createHeadings(sheet: Sheet, user: User) {
            var row = sheet.createRow(0)
            var cell = row.createCell(0)
            cell.setCellValue(nameAndSurname)

            cell = row.createCell(1)
            cell.setCellValue("${user.name} ${user.surname}")

            row = sheet.createRow(2)

            cell = row.createCell(0)
            cell.setCellValue(country)

            cell = row.createCell(1)
            cell.setCellValue(date)

            cell = row.createCell(2)
            cell.setCellValue(time)

            cell = row.createCell(3)
            cell.setCellValue(rideType)
        }

        private fun createContent(sheet: Sheet, drives: List<Drive>) {
            var currentRowNo = 3
            for(drive in drives) {
                var row = sheet.createRow(currentRowNo)
                var cell = row.createCell(0)
                cell.setCellValue(drive.country)

                cell = row.createCell(1)
                cell.setCellValue(drive.date)

                cell = row.createCell(2)
                cell.setCellValue(drive.time)

                cell = row.createCell(3)
                cell.setCellValue(getRideTypeText(drive.type))
                currentRowNo++
            }
        }

        private fun getRideTypeText(type: String): String {
            return when(type) {
                "LOADING" -> "Załadunek"
                "UNLOADING" -> "Rozładunek"
                else -> "Nieznany"
            }
        }

        private fun storeExcelInStorage(context: Context, fileName: String, workbook: HSSFWorkbook): Boolean {
            var isSuccess: Boolean
            val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)
            var fileOutputStream: FileOutputStream? = null
            try {
                fileOutputStream = FileOutputStream(file)
                workbook.write(fileOutputStream)
                isSuccess = true
            } catch (e: IOException) {
                isSuccess = false
            } finally {
                try {
                    fileOutputStream?.close()
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
            return isSuccess
        }

        fun readExcelFromStorage(context: Context, fileName: String): Uri? {
            var file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

            try {
                var fileInputStream = FileInputStream(file);

                var workbook = HSSFWorkbook(fileInputStream);

                var sheet = workbook.getSheetAt(0);
                return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
                sheet.topRow
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        private fun isExternalStorageReadOnly(): Boolean {
            val externalStorageState: String = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState)
        }

        private fun isExternalStorageAvailable(): Boolean {
            val externalStorageState = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == externalStorageState
        }
    }
}