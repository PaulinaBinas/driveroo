package com.pbinas.driveroo.util

class CountryUtil {

    companion object {
        fun getEnglishCountryName(polishCountryName: String): String {
            return when (polishCountryName) {
                "Austria" -> "austria"
                "Belgia" -> "belgium"
                "Bułgaria" -> "bulgaria"
                "Chorwacja" -> "croatia"
                "Cypr" -> "cyprus"
                "Czechy" -> "czechrepublic"
                "Dania" -> "denmark"
                "Estonia" -> "estonia"
                "Finlandia" -> "finland"
                "Francja" -> "france"
                "Grecja" -> "greece"
                "Hiszpania" -> "spain"
                "Holandia" -> "netherlands"
                "Irlandia" -> "ireland"
                "Litwa" -> "lithuania"
                "Łotwa" -> "latvia"
                "Luksemburg" -> "luxembourg"
                "Malta" -> "malta"
                "Niemcy" -> "germany"
                "Norwegia" -> "norway"
                "Polska" -> "poland"
                "Portugalia" -> "portugal"
                "Rumunia" -> "romania"
                "Słowacja" -> "slovakia"
                "Słowenia" -> "slovenia"
                "Szwecja" -> "sweden"
                "Węgry" -> "hungary"
                "Wielka Brytania" -> "unitedkingdom"
                "Włochy" -> "italy"
                else -> ""
            }
        }

        fun getListOfEuropeanCountries(): List<String> {
            val countriesList = ArrayList<String>()
            countriesList.add("Austria")
            countriesList.add("Belgia")
            countriesList.add("Bułgaria")
            countriesList.add("Chorwacja")
            countriesList.add("Cypr")
            countriesList.add("Czechy")
            countriesList.add("Dania")
            countriesList.add("Estonia")
            countriesList.add("Finlandia")
            countriesList.add("Francja")
            countriesList.add("Grecja")
            countriesList.add("Hiszpania")
            countriesList.add("Holandia")
            countriesList.add("Irlandia")
            countriesList.add("Litwa")
            countriesList.add("Łotwa")
            countriesList.add("Luksemburg")
            countriesList.add("Malta")
            countriesList.add("Niemcy")
            countriesList.add("Norwegia")
            countriesList.add("Polska")
            countriesList.add("Portugalia")
            countriesList.add("Rumunia")
            countriesList.add("Słowacja")
            countriesList.add("Słowenia")
            countriesList.add("Szwecja")
            countriesList.add("Węgry")
            countriesList.add("Wielka Brytania")
            countriesList.add("Włochy")
            return countriesList
        }
    }
}