package brawijaya.example.tuteedaftarkelas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen (val route: String) {
    object DaftarKelas : Screen("daftar_kelas")
}

@Composable
fun AppNavigation (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.DaftarKelas.route
    ) {
        composable(Screen.DaftarKelas.route) {

        }
    }
}