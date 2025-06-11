package brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import brawijaya.example.tuteedaftarkelas.R
import brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas.components.ProgramBelajarCard

@Composable
fun PilihProgramBelajarScreen() {

    val imageList = listOf(
        R.drawable.bg_card_1,
        R.drawable.bg_card_3,
        R.drawable.bg_card_5,
        R.drawable.bg_card_7,
        R.drawable.bg_card_2,
        R.drawable.bg_card_4,
        R.drawable.bg_card_6,
        R.drawable.bg_card_8,
    )

    var searchBar by remember { mutableStateOf("") }

    TextField(
        value = searchBar,
        onValueChange = { searchBar = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        singleLine = true,
        placeholder = {
            Text(
                text = "Cari program belajar yang kamu mau!",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFCBD5E1),
            unfocusedPlaceholderColor = Color(0xFF031A2F),
            focusedContainerColor = Color(0xFFCBD5E1),
            focusedPlaceholderColor = Color(0xFF031A2F),
            unfocusedTextColor = Color(0xFFCBD5E1),
            focusedTextColor = Color(0xFF031A2F),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF031A2F)
                )
            }
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize().padding(bottom = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[0],
                title = "Pemrograman Dasar Java"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[1],
                title = "Project Management"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[2],
                title = "Data Mining"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[3],
                title = "Pemrograman Android"
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[4],
                title = "Pemrograman Android"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[5],
                title = "Data Science"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[6],
                title = "Pemrograman Web"
            )
            ProgramBelajarCard(
                modifier = Modifier.weight(1f),
                imageRes = imageList[7],
                title = "Project Management"
            )
        }
    }
}