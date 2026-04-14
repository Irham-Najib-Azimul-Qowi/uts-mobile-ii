package com.example.unscramble.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Rute navigasi untuk aplikasi.
 */
enum class UnscrambleScreen {
    Game,
    Result
}

/**
 * Host navigasi utama.
 */
@Composable
fun UnscrambleNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    // ViewModel diinisialisasi di tingkat NavHost agar dapat dibagikan antar layar jika perlu,
    // atau setidaknya diatur factory-nya di sini.
    val viewModel: GameViewModel = viewModel(factory = AppViewModelProvider.Factory)

    NavHost(
        navController = navController,
        startDestination = UnscrambleScreen.Game.name,
        modifier = modifier
    ) {
        composable(route = UnscrambleScreen.Game.name) {
            GameScreen(
                gameViewModel = viewModel,
                onNavigateToResult = { navController.navigate(UnscrambleScreen.Result.name) }
            )
        }
        composable(route = UnscrambleScreen.Result.name) {
            ResultScreen(
                viewModel = viewModel,
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}
