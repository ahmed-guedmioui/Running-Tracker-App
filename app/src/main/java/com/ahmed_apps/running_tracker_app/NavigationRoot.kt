package com.ahmed_apps.running_tracker_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ahmed_apps.auth.presentation.intro.IntroScreenRoot
import com.ahmed_apps.auth.presentation.register.RegisterScreenRoot

/**
 * @author Ahmed Guedmioui
 */

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate("register")
                },
                onSignInClick = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "register") {
            RegisterScreenRoot(
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


















