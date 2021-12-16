package com.pbinas.driveroo.ui.chooseCountry

class CountryUtil {

    companion object {
        fun getEnglishCountryName(polishCountryName: String): String {
            return when (polishCountryName) {
                "Albania" -> "albania"
                "Andora" -> "andorra"
                "Austria" -> "austria"
                "Belgia" -> "belgium"
                "Białoruś" -> "belarus"
                "Bośnia i Hercegowina" -> "bosniaandherzegovina"
                "Bułgaria" -> "bulgaria"
                "Chorwacja" -> "croatia"
                "Czarnogóra" -> "montenegro"
                "Czechy" -> "czechrepublic"
                "Dania" -> "denmark"
                "Estonia" -> "estonia"
                "Finlandia" -> "finland"
                "Francja" -> "france"
                "Grecja" -> "greece"
                "Hiszpania" -> "spain"
                "Holandia" -> "netherlands"
                "Irlandia" -> "ireland"
                "Islandia" -> "iceland"
                "Kazachstan" -> "kazakhstan"
                "Lichtenstein" -> "liechtenstein"
                "Litwa" -> "latvia"
                "Macedonia Północna" -> "northmacedonia"
                "Malta" -> "malta"
                "Mołdawia" -> "moldova"
                "Monako" -> "monaco"
                "Niemcy" -> "germany"
                "Norwegia" -> "norway"
                "Polska" -> "poland"
                "Portugalia" -> "portugal"
                "Rosja" -> "russia"
                "Rumunia" -> "romania"
                "San Marino" -> "sanmarino"
                "Serbia" -> "serbia"
                "Słowacja" -> "slovakia"
                "Słowenia" -> "slovenia"
                "Szwajcaria" -> "switzerland"
                "Szwecja" -> "sweden"
                "Turcja" -> "turkey"
                "Ukraina" -> "ukraine"
                "Watykan" -> "vaticancity"
                "Węgry" -> "hungary"
                "Wielka Brytania" -> "unitedkingdom"
                "Włochy" -> "italy"
                else -> ""
            }
        }

        fun getListOfEuropeanCountries(): List<String> {
            val countriesList = ArrayList<String>()
            countriesList.add("Albania")
            countriesList.add("Andora")
            countriesList.add("Austria")
            countriesList.add("Belgia")
            countriesList.add("Białoruś")
            countriesList.add("Bośnia i Hercegowina")
            countriesList.add("Bułgaria")
            countriesList.add("Chorwacja")
            countriesList.add("Czarnogóra")
            countriesList.add("Czechy")
            countriesList.add("Dania")
            countriesList.add("Estonia")
            countriesList.add("Finlandia")
            countriesList.add("Francja")
            countriesList.add("Grecja")
            countriesList.add("Hiszpania")
            countriesList.add("Holandia")
            countriesList.add("Irlandia")
            countriesList.add("Islandia")
            countriesList.add("Kazachstan")
            countriesList.add("Lichtenstein")
            countriesList.add("Litwa")
            countriesList.add("Macedonia Północna")
            countriesList.add("Malta")
            countriesList.add("Mołdawia")
            countriesList.add("Monako")
            countriesList.add("Niemcy")
            countriesList.add("Norwegia")
            countriesList.add("Polska")
            countriesList.add("Portugalia")
            countriesList.add("Rosja")
            countriesList.add("Rumunia")
            countriesList.add("San Marino")
            countriesList.add("Serbia")
            countriesList.add("Słowacja")
            countriesList.add("Słowenia")
            countriesList.add("Szwajcaria")
            countriesList.add("Szwecja")
            countriesList.add("Turcja")
            countriesList.add("Ukraina")
            countriesList.add("Watykan")
            countriesList.add("Węgry")
            countriesList.add("Wielka Brytania")
            countriesList.add("Włochy")
            return countriesList
        }
    }
}