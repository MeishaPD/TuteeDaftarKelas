package brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import brawijaya.example.tuteedaftarkelas.R
import brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas.components.PaketBelajarCard
import brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas.components.buildDescriptionText

@Composable
fun PilihPaketBelajarScreen(modifier: Modifier) {
    val imageList = listOf(
        R.drawable.bg_paket_card_1,
        R.drawable.bg_paket_card_2,
        R.drawable.bg_paket_card_3
    )

    Text(
        text = "Pilih paket belajar-mu!",
        color = Color(0xFF031A2F),
        style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),
        modifier = modifier.padding(vertical = 24.dp)
    )

    PaketBelajarCard(
        imageRes = imageList[0],
        title = "One-Time Study",
        description = buildDescriptionText(
            "Pilih jadwalmu untuk 1x pertemuan! Buat belajarmu jadi lebih fokus untuk materi yang kurang kamu kuasai!",
            listOf("1x", "pertemuan!")
        )
    )

    PaketBelajarCard(
        imageRes = imageList[1],
        title = "Short-term Study",
        description = buildDescriptionText(
            "Ngerasa kurang? Coba pembelajaran untuk 1 bulan dengan 4x pertemuan!",
            listOf("1", "bulan", "4x", "pertemuan!")
        )
    )

    PaketBelajarCard(
        imageRes = imageList[2],
        title = "Long-term Study",
        description = buildDescriptionText(
            "Butuh pemahaman lebih dalam? Kamu harus cobain pembelajaran selama 3 bulan untuk 12x pertemuan!",
            listOf("3", "bulan", "12x", "pertemuan!")
        ),
        contentAlignment = Alignment.End
    )
}
