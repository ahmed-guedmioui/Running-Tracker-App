package com.ahmed_apps.running_tracker_app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ahmed_apps.auth.presentation.intro.IntroScreenCore
import com.ahmed_apps.auth.presentation.login.LoginScreenCore
import com.ahmed_apps.auth.presentation.register.RegisterScreenCore

/**
 * @author Ahmed Guedmioui
 */

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "run" else "auth"
    ) {
        authGraph(navController)
        runGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenCore(
                onSignUpClick = {
                    navController.navigate("register")
                },
                onSignInClick = {
                    navController.navigate("login")
                }
            )
        }

        composable(route = "register") {
            RegisterScreenCore(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo("register") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                }
            )
        }

        composable(route = "login") {
            LoginScreenCore(
                onLoginSuccess = {
                    navController.navigate("run") {
                        popUpTo("auth") {
                            inclusive = true
                        }
                    }
                },
                inSignUpClick = {
                    navController.navigate("register") {
                        popUpTo("login") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation(
        startDestination = "run_overview",
        route = "run"
    ) {
        composable("run_overview") {
            Text("run_overview")
        }
    }
}


//@Composable
//fun NavigationRoot(
//    navController: NavHostController
//) {
//    NavHost(
//        navController = navController,
//        startDestination = FeatureScreens.Auth::class
//    ) {
//        authGraph(navController)
//    }
//}
//
//@SuppressLint("RestrictedApi")
//private fun NavGraphBuilder.authGraph(navController: NavHostController) {
//    navigation(
//        startDestination = AuthScreen.Intro,
//        route = FeatureScreens.Auth::class
//    ) {
//        composable<AuthScreen.Intro> {
//            IntroScreenRoot(
//                onSignUpClick = {
//                    navController.navigate(AuthScreen.Register)
//                },
//                onSignInClick = {
//                    navController.navigate(AuthScreen.Login)
//                }
//            )
//        }
//
//        composable<AuthScreen.Login> {
//
//        }
//
//        composable<AuthScreen.Register> {
//            RegisterScreenRoot(
//                onSignInClick = {
//                    navController.navigate(AuthScreen.Login) {
//                        popUpTo(AuthScreen.Register) {
//                            inclusive = true
//                            saveState = true
//                        }
//                    }
//                },
//                onSuccessfulRegistration = {
//                    navController.navigate(AuthScreen.Login)
//                }
//            )
//        }
//    }
//}
//
//sealed interface FeatureScreens {
//    @kotlinx.serialization.Serializable
//    data object Auth : FeatureScreens
//}
//
//sealed interface AuthScreen {
//    @kotlinx.serialization.Serializable
//    data object Intro : AuthScreen
//
//    @kotlinx.serialization.Serializable
//    data object Register : AuthScreen
//
//    @kotlinx.serialization.Serializable
//    data object Login : AuthScreen
//}


















