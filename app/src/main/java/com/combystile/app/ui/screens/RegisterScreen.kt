package com.combystile.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.combystile.app.R

// =============================
// PALETA OSCURA
// =============================

private val BackgroundDark = Color(0xFF111A13)
private val CardDark = Color(0xFF202A21)
private val FieldDark = Color(0xFF202A21)
private val BorderDark = Color(0xFF334036)

private val TextPrimaryDark = Color(0xFFF6F4EF)
private val TextSecondaryDark = Color(0xFFA9AFA9)

// =============================
// PALETA CLARA
// =============================

private val BackgroundLight = Color(0xFFF5EFE8)
private val CardLight = Color(0xFFFFFFFF)
private val FieldLight = Color(0xFFFAF7F3)
private val BorderLight = Color(0xFFD9CEC5)

private val TextPrimaryLight = Color(0xFF232823)
private val TextSecondaryLight = Color(0xFF686E69)

// =============================
// IDENTIDAD COMBYSTILE
// =============================

private val PrimaryBeige = Color(0xFFF2D1B8)
private val PrimaryBeigeDark = Color(0xFFDCAE8F)
private val ButtonText = Color(0xFF29231F)

@Composable
fun RegisterScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onRegister: () -> Unit = {},
    onLogin: () -> Unit = {}
) {

    var nombre by remember {
        mutableStateOf("")
    }

    var correo by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmarPassword by remember {
        mutableStateOf("")
    }

    var mostrarPassword by remember {
        mutableStateOf(false)
    }

    var mostrarConfirmacion by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    // =============================
    // COLORES DEL TEMA
    // =============================

    val backgroundColor =
        if (isDarkTheme) BackgroundDark else BackgroundLight

    val cardColor =
        if (isDarkTheme) CardDark else CardLight

    val fieldColor =
        if (isDarkTheme) FieldDark else FieldLight

    val borderColor =
        if (isDarkTheme) BorderDark else BorderLight

    val textPrimary =
        if (isDarkTheme) TextPrimaryDark else TextPrimaryLight

    val textSecondary =
        if (isDarkTheme) TextSecondaryDark else TextSecondaryLight

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .imePadding()
    ) {

        // =============================
        // TEMA CLARO / OSCURO
        // =============================

        IconButton(
            onClick = onToggleTheme,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(44.dp)
                .clip(CircleShape)
                .background(cardColor)
        ) {

            Icon(
                imageVector =
                    if (isDarkTheme) {
                        Icons.Default.LightMode
                    } else {
                        Icons.Default.DarkMode
                    },
                contentDescription =
                    if (isDarkTheme) {
                        "Cambiar a tema claro"
                    } else {
                        "Cambiar a tema oscuro"
                    },
                tint =
                    if (isDarkTheme) {
                        PrimaryBeige
                    } else {
                        Color(0xFF5E665E)
                    }
            )
        }

        // =============================
        // CONTENIDO
        // =============================

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 68.dp,
                    bottom = 32.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // =============================
            // LOGO
            // =============================

            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),
                contentDescription = "Logo Combystile",
                modifier = Modifier
                    .size(86.dp)
                    .clip(
                        RoundedCornerShape(22.dp)
                    )
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // =============================
            // TÍTULO
            // =============================

            Text(
                text = "Crea tu cuenta",
                color = textPrimary,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Sube tus prendas y descubre nuevas combinaciones",
                color = textSecondary,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // =============================
            // TARJETA REGISTRO
            // =============================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    // =============================
                    // NOMBRE
                    // =============================

                    Text(
                        text = "Nombre",
                        color = textSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Tu nombre",
                                color = textSecondary
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(
                                    FocusDirection.Down
                                )
                            }
                        ),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = fieldColor,
                            unfocusedContainerColor = fieldColor,
                            focusedBorderColor = PrimaryBeige,
                            unfocusedBorderColor = borderColor,
                            cursorColor = PrimaryBeige
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    // =============================
                    // CORREO
                    // =============================

                    Text(
                        text = "Correo electrónico",
                        color = textSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    OutlinedTextField(
                        value = correo,
                        onValueChange = {
                            correo = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "tucorreo@ejemplo.com",
                                color = textSecondary
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(
                                    FocusDirection.Down
                                )
                            }
                        ),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = fieldColor,
                            unfocusedContainerColor = fieldColor,
                            focusedBorderColor = PrimaryBeige,
                            unfocusedBorderColor = borderColor,
                            cursorColor = PrimaryBeige
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    // =============================
                    // CONTRASEÑA
                    // =============================

                    Text(
                        text = "Contraseña",
                        color = textSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Mínimo 6 caracteres",
                                color = textSecondary
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(
                                    FocusDirection.Down
                                )
                            }
                        ),

                        visualTransformation =
                            if (mostrarPassword) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },

                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    mostrarPassword =
                                        !mostrarPassword
                                }
                            ) {

                                Icon(
                                    imageVector =
                                        if (mostrarPassword) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription =
                                        if (mostrarPassword) {
                                            "Ocultar contraseña"
                                        } else {
                                            "Mostrar contraseña"
                                        },
                                    tint = textSecondary
                                )
                            }
                        },

                        shape = RoundedCornerShape(14.dp),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = fieldColor,
                            unfocusedContainerColor = fieldColor,
                            focusedBorderColor = PrimaryBeige,
                            unfocusedBorderColor = borderColor,
                            cursorColor = PrimaryBeige
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    // =============================
                    // CONFIRMAR CONTRASEÑA
                    // =============================

                    Text(
                        text = "Confirmar contraseña",
                        color = textSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    OutlinedTextField(
                        value = confirmarPassword,
                        onValueChange = {
                            confirmarPassword = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Repite la contraseña",
                                color = textSecondary
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        ),

                        visualTransformation =
                            if (mostrarConfirmacion) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },

                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    mostrarConfirmacion =
                                        !mostrarConfirmacion
                                }
                            ) {

                                Icon(
                                    imageVector =
                                        if (mostrarConfirmacion) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                    contentDescription =
                                        if (mostrarConfirmacion) {
                                            "Ocultar contraseña"
                                        } else {
                                            "Mostrar contraseña"
                                        },
                                    tint = textSecondary
                                )
                            }
                        },

                        shape = RoundedCornerShape(14.dp),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = fieldColor,
                            unfocusedContainerColor = fieldColor,
                            focusedBorderColor = PrimaryBeige,
                            unfocusedBorderColor = borderColor,
                            cursorColor = PrimaryBeige
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // =============================
                    // BOTÓN REGISTRARSE
                    // =============================

                    Button(
                        onClick = {
                            focusManager.clearFocus()
                            onRegister()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBeige,
                            contentColor = ButtonText
                        )
                    ) {

                        Text(
                            text = "Registrarme",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            // =============================
            // VOLVER AL LOGIN
            // =============================

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "¿Ya tienes cuenta?",
                    color = textSecondary,
                    fontSize = 13.sp
                )

                TextButton(
                    onClick = onLogin
                ) {

                    Text(
                        text = "Inicia sesión",
                        color = PrimaryBeigeDark,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}