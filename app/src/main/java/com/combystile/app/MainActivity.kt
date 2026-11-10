package com.combystile.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.combystile.app.ui.screens.LoginScreen
import com.combystile.app.ui.screens.RegisterScreen
import com.combystile.app.ui.theme.CombystileTheme

private enum class AuthScreen {
    LOGIN,
    REGISTER
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            var isDarkTheme by remember {
                mutableStateOf(true)
            }

            var currentScreen by remember {
                mutableStateOf(AuthScreen.LOGIN)
            }

            CombystileTheme(
                darkTheme = isDarkTheme
            ) {

                when (currentScreen) {

                    AuthScreen.LOGIN -> {

                        LoginScreen(
                            isDarkTheme = isDarkTheme,

                            onToggleTheme = {
                                isDarkTheme = !isDarkTheme
                            },

                            onLogin = {
                                // Próximamente irá al Home
                            },

                            onRegister = {
                                currentScreen =
                                    AuthScreen.REGISTER
                            }
                        )
                    }

                    AuthScreen.REGISTER -> {

                        RegisterScreen(
                            isDarkTheme = isDarkTheme,

                            onToggleTheme = {
                                isDarkTheme = !isDarkTheme
                            },

                            onRegister = {
                                // Backend TypeScript después
                            },

                            onLogin = {
                                currentScreen =
                                    AuthScreen.LOGIN
                            }
                        )
                    }
                }
            }
        }
    }
}