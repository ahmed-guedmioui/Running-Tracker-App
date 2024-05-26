package com.ahmed_apps.running_tracker_app

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.ahmed_apps.core.presentation.designsystem.RunningTrackerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        enableEdgeToEdge()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.state.isCheckingAuth
            }
        }

        setContent {
            RunningTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    if (!viewModel.state.isCheckingAuth) {
                        val navController = rememberNavController()
                        NavigationRoot(
                            navController = navController,
                            isLoggedIn = viewModel.state.isLoggedIn
                        )
                    }
                }
            }
        }
    }
}
















