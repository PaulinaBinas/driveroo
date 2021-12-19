package com.pbinas.driveroo.util

import android.content.Context
import android.os.Environment
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
        private var country = "Państwo odcinka zagranicznego"
        private var entryDate = "Data wjazdu"
        private var hour = "Godzina"
        private var leavingDate = "Data wyjazdu"
        private var goalCountry = "Państwo docelowe"
        private var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        private var timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        fun createNewFile(context: Context, drives: List<Drive>, user: User) {
            if(drives.isNotEmpty()) {
                val workbook = HSSFWorkbook()
                val sheet: Sheet = workbook.createSheet()
                var row = sheet.createRow(0)
                var cell = row.createCell(0)
                cell.setCellValue(nameAndSurname)

                cell = row.createCell(1)
                cell.setCellValue("${user.name} ${user.surname}")

                row = sheet.createRow(2)

                cell = row.createCell(0)
                cell.setCellValue(country)

                cell = row.createCell(1)
                cell.setCellValue(entryDate)

                cell = row.createCell(2)
                cell.setCellValue(hour)

                cell = row.createCell(3)
                cell.setCellValue(leavingDate)

                cell = row.createCell(4)
                cell.setCellValue(hour)

                cell = row.createCell(5)
                cell.setCellValue(goalCountry)

                var date = LocalDate.parse(drives.firstOrNull()?.date, dateFormatter)
                var dateText = date.format(DateTimeFormatter.ofPattern("yyyy_MM"))
                var filename = "${user.name}_${user.surname}_$dateText"
                storeExcelInStorage(context, filename, workbook)
                readExcelFromStorage(context, filename)
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

        private fun readExcelFromStorage(context: Context, fileName: String) {
            var file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

            try {
                var fileInputStream = FileInputStream(file);

                var workbook = HSSFWorkbook(fileInputStream);

                var sheet = workbook.getSheetAt(0);
                sheet.topRow
            } catch (e: Exception) {
                e.printStackTrace()
            }
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