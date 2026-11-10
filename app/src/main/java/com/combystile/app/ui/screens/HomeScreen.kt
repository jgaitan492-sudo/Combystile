package com.combystile.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==========================================
// COLORES COMBYSTILE
// ==========================================

private val BackgroundDark = Color(0xFF111A13)
private val CardDark = Color(0xFF202A21)
private val CardSecondary = Color(0xFF263128)

private val PrimaryBeige = Color(0xFFF2D1B8)
private val PrimaryBeigeDark = Color(0xFFDCAE8F)

private val TextPrimary = Color(0xFFF6F4EF)
private val TextSecondary = Color(0xFFA9AFA9)
private val TextButton = Color(0xFF29231F)

private val NavigationDark = Color(0xFF182019)

@Composable
fun HomeScreen(
    nombreUsuario: String = "Usuario",
    cantidadPrendas: Int = 0,
    cantidadFavoritos: Int = 0,
    onProfile: () -> Unit = {},
    onAddGarment: () -> Unit = {},
    onGenerateCombination: () -> Unit = {},
    onHome: () -> Unit = {},
    onHistory: () -> Unit = {},
    onCamera: () -> Unit = {},
    onCombinations: () -> Unit = {},
    onFavorites: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {

        // ==========================================
        // CONTENIDO PRINCIPAL
        // ==========================================

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 16.dp,
                    bottom = 24.dp
                )
        ) {

            // ======================================
            // ENCABEZADO
            // ======================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {

                    Text(
                        text = "combystile",
                        color = TextPrimary,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "TU ESTILO, MÁS FÁCIL",
                        color = TextSecondary,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // PERFIL
                IconButton(
                    onClick = onProfile,
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = CardDark,
                            shape = CircleShape
                        )
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil",
                        tint = PrimaryBeige,
                        modifier = Modifier.size(27.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            // ======================================
            // BIENVENIDA
            // ======================================

            Text(
                text = "Hola, $nombreUsuario",
                color = TextPrimary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "¿Qué quieres usar hoy?",
                color = TextSecondary,
                fontSize = 15.sp
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // ======================================
            // RESUMEN DEL ARMARIO
            // ======================================

            Text(
                text = "Tu armario",
                color = TextPrimary,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                SummaryCard(
                    modifier = Modifier.weight(1f),
                    number = cantidadPrendas.toString(),
                    label = "Prendas",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Checkroom,
                            contentDescription = null,
                            tint = PrimaryBeige,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                )

                SummaryCard(
                    modifier = Modifier.weight(1f),
                    number = cantidadFavoritos.toString(),
                    label = "Favoritos",
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = PrimaryBeige,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // ======================================
            // AGREGAR PRENDA
            // ======================================

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onAddGarment()
                    },
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardDark
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .background(
                                color = CardSecondary,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = PrimaryBeige,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {

                        Text(
                            text = "Agregar prenda",
                            color = TextPrimary,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "Toma una foto y agrégala a tu armario",
                            color = TextSecondary,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            // ======================================
            // GENERAR COMBINACIÓN
            // ======================================

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onGenerateCombination()
                    },
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardDark
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .background(
                                color = CardSecondary,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Checkroom,
                            contentDescription = null,
                            tint = PrimaryBeige,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {

                        Text(
                            text = "Crear combinación",
                            color = TextPrimary,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "Genera hasta 10 outfits con tus prendas",
                            color = TextSecondary,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // ======================================
            // BOTÓN PRINCIPAL
            // ======================================

            Button(
                onClick = onGenerateCombination,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBeige,
                    contentColor = TextButton
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Checkroom,
                    contentDescription = null
                )

                Text(
                    text = "  Crear un outfit",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Combina las prendas de tu armario y descubre nuevas formas de vestir.",
                modifier = Modifier.fillMaxWidth(),
                color = TextSecondary,
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
        }

        // ==========================================
        // BARRA INFERIOR
        // ==========================================

        NavigationBar(
            containerColor = NavigationDark,
            contentColor = TextPrimary
        ) {

            // INICIO
            NavigationBarItem(
                selected = true,
                onClick = onHome,
                icon = {

                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Inicio"
                    )
                },
                label = {
                    Text("Inicio")
                },
                colors = navigationColors()
            )

            // HISTORIAL
            NavigationBarItem(
                selected = false,
                onClick = onHistory,
                icon = {

                    Icon(
                        imageVector = Icons.Outlined.History,
                        contentDescription = "Historial"
                    )
                },
                label = {
                    Text("Historial")
                },
                colors = navigationColors()
            )

            // CÁMARA
            NavigationBarItem(
                selected = false,
                onClick = onCamera,
                icon = {

                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                color = PrimaryBeige,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Cámara",
                            tint = TextButton,
                            modifier = Modifier.size(27.dp)
                        )
                    }
                },
                label = {
                    Text("Cámara")
                },
                colors = navigationColors()
            )

            // COMBINAR
            NavigationBarItem(
                selected = false,
                onClick = onCombinations,
                icon = {

                    Icon(
                        imageVector = Icons.Default.Checkroom,
                        contentDescription = "Combinar"
                    )
                },
                label = {
                    Text("Combinar")
                },
                colors = navigationColors()
            )

            // FAVORITOS
            NavigationBarItem(
                selected = false,
                onClick = onFavorites,
                icon = {

                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favoritos"
                    )
                },
                label = {
                    Text("Favoritos")
                },
                colors = navigationColors()
            )
        }
    }
}

// ==========================================
// TARJETA RESUMEN
// ==========================================

@Composable
private fun SummaryCard(
    modifier: Modifier = Modifier,
    number: String,
    label: String,
    icon: @Composable () -> Unit
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardDark
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            icon()

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = number,
                color = TextPrimary,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = TextSecondary,
                fontSize = 12.sp
            )
        }
    }
}

// ==========================================
// COLORES DE NAVEGACIÓN
// ==========================================

@Composable
private fun navigationColors() =
    NavigationBarItemDefaults.colors(
        selectedIconColor = PrimaryBeige,
        selectedTextColor = PrimaryBeige,
        unselectedIconColor = TextSecondary,
        unselectedTextColor = TextSecondary,
        indicatorColor = CardSecondary
    )