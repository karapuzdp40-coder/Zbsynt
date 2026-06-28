package com.absynth.hostel.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Elevator
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.SupportAgent
import androidx.compose.ui.graphics.vector.ImageVector
import com.absynth.hostel.R

/** Static, fully offline content describing Absynt Hostel (data from absynthostel.pl). */
object HostelInfo {
    const val NAME = "Absynt Hostel"
    const val CITY = "Wrocław"
    const val TAGLINE = "Wrocław u progu drzwi"
    const val SUBTITLE = "Boutique hostel w zabytkowej kamienicy — 100 m od Rynku."
    const val ADDRESS = "ul. Świętego Antoniego 15, Wrocław"
    const val DISTRICT = "Dzielnica Czterech Wyznań"
    const val PHONE = "+48 695 974 960"
    const val PHONE_RAW = "+48695974960"
    const val WEBSITE = "https://www.absynthostel.pl"
    const val RECEPTION = "Recepcja 24h · zameldowanie od 15:00"
    const val SINCE = "Świadczymy usługi od 1991 roku"
    const val CAPACITY = "150 miejsc noclegowych w centrum Wrocławia"
    const val PARKING = "Parking podziemny przy ul. Świętego Antoniego (2 min od hostelu) — 50 zł/doba."

    val ABOUT = listOf(
        "Mieścimy się w odrestaurowanej, zabytkowej kamienicy w samym sercu Wrocławia, " +
            "przy jednej z najstarszych ulic miasta.",
        "Gruntowny remont sprawił, że oferujemy wygodny nocleg dla turystów i grup — " +
            "wygodne łóżka, czysta pościel i przyjazna atmosfera.",
        "Recepcja działa całą dobę, a do Rynku dojdziesz pieszo w kilka minut."
    )
}

data class Amenity(val label: String, val icon: ImageVector)

val amenities = listOf(
    Amenity("Darmowe Wi-Fi", Icons.Filled.Wifi),
    Amenity("Recepcja 24h", Icons.Outlined.SupportAgent),
    Amenity("Kawa i herbata", Icons.Filled.LocalCafe),
    Amenity("Winda", Icons.Filled.Elevator),
    Amenity("Parking", Icons.Filled.LocalParking),
    Amenity("Centrum", Icons.Filled.LocationCity),
    Amenity("Klimatyzacja", Icons.Filled.AcUnit),
)

data class RoomType(
    val name: String,
    val capacity: Int,
    val dorm: Boolean,
    val description: String,
)

val rooms = listOf(
    RoomType("Pokój 1-osobowy", 1, false, "Kameralny pokój prywatny dla jednej osoby — idealny na pobyt służbowy."),
    RoomType("Pokój 2-osobowy", 2, false, "Komfortowy pokój prywatny dla pary lub dwóch osób."),
    RoomType("Pokój 3-osobowy", 3, false, "Przestronny pokój prywatny dla małej grupy lub rodziny."),
    RoomType("Pokój 4-osobowy", 4, false, "Rodzinny pokój prywatny z wygodnymi łóżkami."),
    RoomType("Pokój 6-osobowy", 6, false, "Duży pokój prywatny dla większej grupy znajomych."),
    RoomType("Pokój 8-osobowy", 8, false, "Najwiekszy pokój prywatny — świetny dla zorganizowanych grup."),
    RoomType("Łóżko w pokoju 6-osobowym", 6, true, "Miejsce w przestronnym dormitorium — nocleg w najlepszej cenie."),
    RoomType("Łóżko w pokoju 8-osobowym", 8, true, "Miejsce w 8-osobowym dormitorium dla budżetowych podróżników."),
)

data class Attraction(
    val name: String,
    val distance: String,
    val description: String,
    val image: Int,
)

val attractions = listOf(
    Attraction("Rynek", "5 minut spacerem", "Jeden z najpiękniejszych placów w Europie — kolorowe kamienice i fontanny.", R.drawable.hero_rynek),
    Attraction("Ostrów Tumski", "nad Odrą", "Katedra, wyspy i nadbrzeże — Wrocław, miasto mostów i historii.", R.drawable.attraction_tumski),
    Attraction("Stare Miasto", "tuż obok", "Zabytkowe elewacje, kawiarnie i klimatyczne uliczki Starówki.", R.drawable.room_interior),
)
