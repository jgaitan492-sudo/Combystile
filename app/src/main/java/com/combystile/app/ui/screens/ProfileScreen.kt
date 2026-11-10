package com.combystile.app.ui.screens

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ProfileBackground = Color(0xFF111A13)
private val ProfileCard = Color(0xFF202A21)
private val ProfileSecondary = Color(0xFF263128)

private val ProfileBeige = Color(0xFFF2D1B8)
private val ProfileText = Color(0xFFF6F4EF)
private val ProfileMuted = Color(0xFFA9AFA9)

private val LogoutColor = Color(0xFFE69A93)

@Composable
fun ProfileScreen(
    nombre: String = "Usuario",
    correo: String = "usuario@combystile.com",
    fechaRegistro: String = "09 nov. 2026",
    cantidadPrendas: Int = 0,
    cantidadCombinaciones: Int = 0,
    cantidadFavoritos: Int = 0,
    onBack: () -> Unit = {},
    onChangePhoto: () -> Unit = {},
    onEditProfile: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ProfileBackground)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ENCABEZADO

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBack
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = ProfileText
                )
            }

            Text(
                text = "Perfil",
                color = ProfileText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // FOTO PERFIL

        Box(
            contentAlignment = Alignment.BottomEnd
        ) {

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(
                        ProfileCard,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Foto de perfil",
                    tint = ProfileBeige,
                    modifier = Modifier.size(65.dp)
                )
            }

            IconButton(
                onClick = onChangePhoto,
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        ProfileBeige,
                        CircleShape
                    )
            ) {

                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Cambiar foto",
                    tint = Color(0xFF29231F)
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = nombre,
            color = ProfileText,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            text = correo,
            color = ProfileMuted,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // DATOS PERSONALES

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = ProfileCard
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                ProfileInfoRow(
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = ProfileBeige
                        )
                    },
                    label = "Nombre",
                    value = nombre
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                ProfileInfoRow(
                    icon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = null,
                            tint = ProfileBeige
                        )
                    },
                    label = "Correo",
                    value = correo
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                ProfileInfoRow(
                    icon = {
                        Icon(
                            Icons.Default.CalendarMonth,
                            contentDescription = null,
                            tint = ProfileBeige
                        )
                    },
                    label = "Miembro desde",
                    value = fechaRegistro
                )
            }
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // ESTADÍSTICAS

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            ProfileStat(
                modifier = Modifier.weight(1f),
                number = cantidadPrendas,
                label = "Prendas",
                icon = {
                    Icon(
                        Icons.Default.Checkroom,
                        contentDescription = null,
                        tint = ProfileBeige
                    )
                }
            )

            ProfileStat(
                modifier = Modifier.weight(1f),
                number = cantidadCombinaciones,
                label = "Outfits",
                icon = {
                    Icon(
                        Icons.Default.Checkroom,
                        contentDescription = null,
                        tint = ProfileBeige
                    )
                }
            )

            ProfileStat(
                modifier = Modifier.weight(1f),
                number = cantidadFavoritos,
                label = "Favoritos",
                icon = {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        tint = ProfileBeige
                    )
                }
            )
        }

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        // CAMBIAR FOTO

        OutlinedButton(
            onClick = onChangePhoto,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp)
        ) {

            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = null,
                tint = ProfileBeige
            )

            Text(
                text = "  Cambiar foto",
                color = ProfileBeige,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // EDITAR PERFIL

        Button(
            onClick = onEditProfile,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ProfileBeige,
                contentColor = Color(0xFF29231F)
            )
        ) {

            Text(
                text = "Editar perfil",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // CERRAR SESIÓN

        OutlinedButton(
            onClick = onLogout,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp)
        ) {

            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = null,
                tint = LogoutColor
            )

            Text(
                text = "  Cerrar sesión",
                color = LogoutColor,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}

@Composable
private fun ProfileInfoRow(
    icon: @Composable () -> Unit,
    label: String,
    value: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(44.dp)
                .background(
                    ProfileSecondary,
                    RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }

        Column(
            modifier = Modifier.padding(start = 13.dp)
        ) {

            Text(
                text = label,
                color = ProfileMuted,
                fontSize = 11.sp
            )

            Text(
                text = value,
                color = ProfileText,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun ProfileStat(
    modifier: Modifier,
    number: Int,
    label: String,
    icon: @Composable () -> Unit
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = ProfileCard
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 15.dp,
                    horizontal = 6.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            icon()

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Text(
                text = number.toString(),
                color = ProfileText,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = ProfileMuted,
                fontSize = 10.sp
            )
        }
    }
}