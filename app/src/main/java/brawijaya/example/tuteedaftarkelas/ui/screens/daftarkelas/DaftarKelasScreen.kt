package brawijaya.example.tuteedaftarkelas.ui.screens.daftarkelas

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarKelasScreen(
    navController: NavController
) {
    var progress by remember { mutableFloatStateOf(3/5f) }
    var selectedProgram by remember { mutableStateOf<String?>(null) }
    var selectedModules by remember { mutableStateOf(setOf<Int>()) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 500, easing = EaseInOutCubic),
        label = "progress_animation"
    )

    Scaffold(
        topBar = {
            Surface(
                shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
                color = Color(0xFF052B4F),
                shadowElevation = 4.dp
            ) {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                if (progress > 1/5f) {
                                    progress = 1/5f
                                    selectedProgram = null
                                }
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color.White
                            ),
                            modifier = Modifier.size(35.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ChevronLeft,
                                contentDescription = "Back"
                            )
                        }
                    },
                    title = {
                        Text(
                            text = "Daftar Kelas",
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 16.dp)
                )
            }
        },
        floatingActionButton = {
            if (progress == 3/5f && selectedModules.isNotEmpty()) {
                ExtendedFloatingActionButton(
                    onClick = { progress = 4/5f },
                    containerColor = Color(0xFF052B4F),
                    contentColor = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .shadow(8.dp, RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text = "Selanjutnya",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF031A2F))
            ) {
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    color = Color(0xFFFFB61A),
                    trackColor = Color.Transparent,
                    modifier = Modifier.fillMaxSize().padding(2.dp),
                )
            }

            if (progress == 1/5f) {
                PilihProgramBelajarScreen(
                    onProgramSelected = { programTitle ->
                        println("DEBUG: Program selected - $programTitle")
                        selectedProgram = programTitle
                        progress = 2/5f
                        println("DEBUG: Progress updated to $progress")
                    }
                )
            } else if (progress == 2/5f) {
                PilihPaketBelajarScreen(
                    modifier = Modifier.align(Alignment.Start),
//                    selectedProgram = selectedProgram ?: ""
                )
            } else if (progress == 3/5f) {
                PilihModulBelajarScreen(
                    modifier = Modifier.align(Alignment.Start),
                    selectedModules = selectedModules,
                    onModuleSelectionChanged = { newSelectedModules ->
                        selectedModules = newSelectedModules
                    }
                )
            } else if (progress == 4/5f) {

            }
        }
    }
}