package com.absynth.hostel.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.MeetingRoom
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.absynth.hostel.R
import com.absynth.hostel.data.Amenity
import com.absynth.hostel.data.Attraction
import com.absynth.hostel.data.HostelInfo
import com.absynth.hostel.data.RoomType
import com.absynth.hostel.data.amenities
import com.absynth.hostel.data.attractions
import com.absynth.hostel.data.rooms
import com.absynth.hostel.ui.theme.Charcoal
import com.absynth.hostel.ui.theme.Cream
import com.absynth.hostel.ui.theme.FaintText
import com.absynth.hostel.ui.theme.MutedText
import com.absynth.hostel.ui.theme.Sand
import com.absynth.hostel.ui.theme.Snow
import com.absynth.hostel.ui.theme.TealDeep
import com.absynth.hostel.ui.theme.TealPale
import com.absynth.hostel.ui.theme.TealPrimary

/* --------------------------------- HOME --------------------------------- */

@Composable
fun HomeScreen(onBook: () -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        // Hero
        Box(modifier = Modifier.fillMaxWidth().height(440.dp)) {
            Image(
                painter = painterResource(R.drawable.hero_rynek),
                contentDescription = "Rynek we Wrocławiu",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0f to Color(0x33000000),
                            0.55f to Color(0x66000000),
                            1f to Color(0xF2000000)
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(24.dp)
            ) {
                Text("ABSYNT", fontSize = 44.sp, fontWeight = FontWeight.ExtraBold, color = Snow, letterSpacing = 4.sp)
                Text("HOSTEL · WROCŁAW", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Sand, letterSpacing = 3.sp)
                Spacer(Modifier.height(10.dp))
                Text(HostelInfo.TAGLINE, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = Snow)
                Spacer(Modifier.height(4.dp))
                Text(HostelInfo.SUBTITLE, fontSize = 13.sp, color = Color(0xFFD7E4E8), lineHeight = 18.sp)
                Spacer(Modifier.height(18.dp))
                Button(
                    onClick = onBook,
                    colors = ButtonDefaults.buttonColors(containerColor = Sand, contentColor = Charcoal),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.height(50.dp)
                ) {
                    Text("Zarezerwuj pobyt", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Spacer(Modifier.width(8.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp))
                }
            }
        }

        // Quick info strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TealDeep)
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoPill(Icons.Filled.Place, HostelInfo.DISTRICT)
            InfoPill(Icons.Filled.AccessTime, "Recepcja 24h")
        }

        SectionTitle("Co oferujemy?")
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(amenities) { AmenityCard(it) }
        }

        SectionTitle("O nas")
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Snow),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(Modifier.padding(18.dp)) {
                Badge(HostelInfo.SINCE)
                Spacer(Modifier.height(6.dp))
                Badge(HostelInfo.CAPACITY)
                Spacer(Modifier.height(14.dp))
                HostelInfo.ABOUT.forEach {
                    Text("•  $it", fontSize = 14.sp, color = MutedText, lineHeight = 21.sp, modifier = Modifier.padding(bottom = 8.dp))
                }
            }
        }

        SectionTitle("Atrakcje w zasięgu ręki")
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(attractions) { AttractionCard(it) }
        }

        Spacer(Modifier.height(20.dp))

        // Contact CTA
        Card(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = TealPrimary)
        ) {
            Column(Modifier.padding(20.dp)) {
                Text("Zaplanuj pobyt", color = Snow, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))
                Text(HostelInfo.ADDRESS, color = Color(0xFFE4F0F3), fontSize = 13.sp)
                Spacer(Modifier.height(14.dp))
                Button(
                    onClick = { dial(context, HostelInfo.PHONE_RAW) },
                    colors = ButtonDefaults.buttonColors(containerColor = Snow, contentColor = TealDeep),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Icon(Icons.Filled.Call, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(HostelInfo.PHONE, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

/* --------------------------------- ROOMS -------------------------------- */

@Composable
fun RoomsScreen() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Cream),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                Image(
                    painter = painterResource(R.drawable.room_interior),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    Modifier.fillMaxSize().background(
                        Brush.verticalGradient(0f to Color(0x33000000), 1f to Color(0xCC000000))
                    )
                )
                Column(Modifier.align(Alignment.BottomStart).padding(20.dp)) {
                    Text("Nasze pokoje", color = Snow, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
                    Text("Najlepsze ceny noclegów we Wrocławiu", color = Sand, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
        items(rooms) { room ->
            RoomCard(room, onBook = { dial(context, HostelInfo.PHONE_RAW) })
        }
    }
}

@Composable
private fun RoomCard(room: RoomType, onBook: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Snow),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(shape = RoundedCornerShape(14.dp), color = TealPale, modifier = Modifier.size(54.dp)) {
                    Icon(
                        if (room.dorm) Icons.Outlined.Bed else Icons.Outlined.MeetingRoom,
                        contentDescription = null,
                        tint = TealPrimary,
                        modifier = Modifier.padding(14.dp)
                    )
                }
                Spacer(Modifier.width(14.dp))
                Column(Modifier.weight(1f)) {
                    Text(room.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TealDeep)
                    Text(
                        if (room.dorm) "Dormitorium" else "Pokój prywatny",
                        fontSize = 12.sp, color = Sand, fontWeight = FontWeight.SemiBold
                    )
                }
                CapacityChip(room.capacity)
            }
            Spacer(Modifier.height(10.dp))
            Text(room.description, fontSize = 13.sp, color = MutedText, lineHeight = 19.sp)
            Spacer(Modifier.height(14.dp))
            Button(
                onClick = onBook,
                colors = ButtonDefaults.buttonColors(containerColor = TealPrimary, contentColor = Snow),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().height(46.dp)
            ) {
                Icon(Icons.Filled.Call, contentDescription = null, modifier = Modifier.size(17.dp))
                Spacer(Modifier.width(8.dp))
                Text("Sprawdź dostępność", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun CapacityChip(n: Int) {
    Surface(shape = CircleShape, color = TealDeep) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Person, contentDescription = null, tint = Snow, modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(3.dp))
            Text("$n", color = Snow, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }
    }
}

/* -------------------------------- CONTACT ------------------------------- */

@Composable
fun ContactScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().background(Cream).verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(TealPrimary, TealDeep)))
                .padding(24.dp)
        ) {
            Column {
                Text("Kontakt", color = Snow, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                Text(HostelInfo.NAME + " · " + HostelInfo.CITY, color = Sand, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        Column(Modifier.padding(16.dp)) {
            ContactRow(Icons.Filled.Place, "Adres", HostelInfo.ADDRESS) {
                openUri(context, "geo:0,0?q=" + Uri.encode(HostelInfo.ADDRESS))
            }
            ContactRow(Icons.Filled.Call, "Telefon", HostelInfo.PHONE) { dial(context, HostelInfo.PHONE_RAW) }
            ContactRow(Icons.Filled.Language, "Strona", "absynthostel.pl") { openUri(context, HostelInfo.WEBSITE) }
            ContactRow(Icons.Filled.AccessTime, "Recepcja", HostelInfo.RECEPTION, null)
            ContactRow(Icons.Filled.LocalParking, "Parking", HostelInfo.PARKING, null)
            ContactRow(Icons.Filled.Map, "Lokalizacja", "Pokaż na mapie") {
                openUri(context, "geo:0,0?q=" + Uri.encode(HostelInfo.ADDRESS))
            }

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { dial(context, HostelInfo.PHONE_RAW) },
                colors = ButtonDefaults.buttonColors(containerColor = TealPrimary, contentColor = Snow),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Icon(Icons.Filled.Call, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Zadzwoń i zarezerwuj", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(
                onClick = { openUri(context, HostelInfo.WEBSITE) },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Icon(Icons.Filled.Language, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Rezerwacja online", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))
            Text(HostelInfo.SINCE, fontSize = 12.sp, color = FaintText, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, value: String, onClick: (() -> Unit)?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Snow),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(shape = CircleShape, color = TealPale, modifier = Modifier.size(42.dp)) {
                Icon(icon, contentDescription = null, tint = TealPrimary, modifier = Modifier.padding(10.dp))
            }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(title, fontSize = 12.sp, color = FaintText, fontWeight = FontWeight.SemiBold)
                Text(value, fontSize = 14.sp, color = TealDeep, fontWeight = FontWeight.Medium, lineHeight = 19.sp)
            }
        }
    }
}

/* ------------------------------- SHARED UI ------------------------------ */

@Composable
private fun SectionTitle(text: String) {
    Text(
        text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = TealDeep,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 14.dp)
    )
}

@Composable
private fun InfoPill(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Sand, modifier = Modifier.size(16.dp))
        Spacer(Modifier.width(6.dp))
        Text(text, color = Snow, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun Badge(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(8.dp).clip(CircleShape).background(Sand))
        Spacer(Modifier.width(8.dp))
        Text(text, fontSize = 13.sp, color = TealDeep, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun AmenityCard(a: Amenity) {
    Column(
        modifier = Modifier
            .width(96.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Snow)
            .padding(vertical = 16.dp, horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(shape = CircleShape, color = TealPale, modifier = Modifier.size(48.dp)) {
            Icon(a.icon, contentDescription = a.label, tint = TealPrimary, modifier = Modifier.padding(12.dp))
        }
        Spacer(Modifier.height(8.dp))
        Text(a.label, fontSize = 11.sp, color = MutedText, textAlign = TextAlign.Center, fontWeight = FontWeight.Medium, lineHeight = 14.sp)
    }
}

@Composable
private fun AttractionCard(a: Attraction) {
    Card(
        modifier = Modifier.width(240.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Snow),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            Box(Modifier.fillMaxWidth().height(140.dp)) {
                Image(
                    painter = painterResource(a.image),
                    contentDescription = a.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    Modifier.fillMaxSize().background(
                        Brush.verticalGradient(0f to Color.Transparent, 1f to Color(0xAA000000))
                    )
                )
                Text(
                    a.distance,
                    color = Snow, fontSize = 11.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Sand)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }
            Column(Modifier.padding(14.dp)) {
                Text(a.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TealDeep)
                Spacer(Modifier.height(4.dp))
                Text(a.description, fontSize = 12.sp, color = MutedText, lineHeight = 17.sp)
            }
        }
    }
}

/* -------------------------------- HELPERS ------------------------------- */

private fun dial(context: android.content.Context, phone: String) {
    runCatching {
        context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
    }
}

private fun openUri(context: android.content.Context, uri: String) {
    runCatching {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    }
}
