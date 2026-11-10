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
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BackgroundDark = Color(0xFF111A13)
private val CardDark = Color(0xFF202A21)
private val CardSecondary = Color(0xFF263128)
private val NavigationDark = Color(0xFF182019)

private val PrimaryBeige = Color(0xFFF2D1B8)
private val TextPrimary = Color(0xFFF6F4EF)
private val TextSecondary = Color(0xFFA9AFA9)
private val Danger = Color(0xFFE69A93)
private val TextDark = Color(0xFF29231F)

data class HistoryItem(
    val id: Int,
    val title: String,
    val date: String,
    val description: String
)

@Composable
fun HistoryScreen(
    items: List<HistoryItem> = demoHistoryItems(),
    onDelete: (HistoryItem) -> Unit = {},
    onProfile: () -> Unit = {},
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

            // Encabezado

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Column {

                    Text(
                        text = "Historial",
                        color = TextPrimary,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Tus combinaciones anteriores",
                        color = TextSecondary,
                        fontSize = 13.sp
                    )
                }

                IconButton(
                    onClick = onProfile,
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            CardDark,
                            CircleShape
                        )
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.Person,
                        contentDescription = "Perfil",
                        tint = PrimaryBeige,
                        modifier = Modifier.size(27.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // Cantidad de combinaciones

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardDark
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                CardSecondary,
                                RoundedCornerShape(15.dp)
                            ),
                        contentAlignment =
                            Alignment.Center
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.History,
                            contentDescription = null,
                            tint = PrimaryBeige,
                            modifier = Modifier.size(27.dp)
                        )
                    }

                    Column(
                        modifier = Modifier.padding(
                            start = 15.dp
                        )
                    ) {

                        Text(
                            text =
                                "${items.size} combinaciones",
                            color = TextPrimary,
                            fontSize = 18.sp,
                            fontWeight =
                                FontWeight.Bold
                        )

                        Text(
                            text =
                                "Generadas recientemente",
                            color = TextSecondary,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            if (items.isEmpty()) {

                EmptyHistory()

            } else {

                Text(
                    text = "Recientes",
                    color = TextPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                items.forEach { item ->

                    HistoryCard(
                        item = item,
                        onDelete = {
                            onDelete(item)
                        }
                    )

                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )
                }
            }
        }

        BottomNavigation(
            onHome = onHome,
            onHistory = onHistory,
            onCamera = onCamera,
            onCombinations = onCombinations,
            onFavorites = onFavorites
        )
    }
}

@Composable
private fun HistoryCard(
    item: HistoryItem,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardDark
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(
                        CardSecondary,
                        RoundedCornerShape(17.dp)
                    ),
                contentAlignment =
                    Alignment.Center
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Checkroom,
                    contentDescription = null,
                    tint = PrimaryBeige,
                    modifier = Modifier.size(30.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp)
            ) {

                Text(
                    text = item.title,
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = item.description,
                    color = TextSecondary,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = item.date,
                    color = PrimaryBeige,
                    fontSize = 11.sp
                )
            }

            IconButton(
                onClick = onDelete
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Delete,
                    contentDescription =
                        "Eliminar del historial",
                    tint = Danger
                )
            }
        }
    }
}

@Composable
private fun EmptyHistory() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 70.dp,
                bottom = 70.dp
            ),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    CardDark,
                    CircleShape
                ),
            contentAlignment =
                Alignment.Center
        ) {

            Icon(
                imageVector =
                    Icons.Default.History,
                contentDescription = null,
                tint = PrimaryBeige,
                modifier = Modifier.size(38.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = "Aún no tienes historial",
            color = TextPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        Text(
            text =
                "Cuando generes combinaciones aparecerán aquí.",
            color = TextSecondary,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun BottomNavigation(
    onHome: () -> Unit,
    onHistory: () -> Unit,
    onCamera: () -> Unit,
    onCombinations: () -> Unit,
    onFavorites: () -> Unit
) {

    NavigationBar(
        containerColor = NavigationDark
    ) {

        NavigationBarItem(
            selected = false,
            onClick = onHome,
            icon = {

                Icon(
                    imageVector =
                        Icons.Default.Home,
                    contentDescription = "Inicio"
                )
            },
            label = {
                Text("Inicio")
            },
            colors = navigationColors()
        )

        NavigationBarItem(
            selected = true,
            onClick = onHistory,
            icon = {

                Icon(
                    imageVector =
                        Icons.Default.History,
                    contentDescription = "Historial"
                )
            },
            label = {
                Text("Historial")
            },
            colors = navigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onCamera,
            icon = {

                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            PrimaryBeige,
                            CircleShape
                        ),
                    contentAlignment =
                        Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.CameraAlt,
                        contentDescription = "Cámara",
                        tint = TextDark,
                        modifier =
                            Modifier.size(27.dp)
                    )
                }
            },
            label = {
                Text("Cámara")
            },
            colors = navigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onCombinations,
            icon = {

                Icon(
                    imageVector =
                        Icons.Default.Checkroom,
                    contentDescription = "Combinar"
                )
            },
            label = {
                Text("Combinar")
            },
            colors = navigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onFavorites,
            icon = {

                Icon(
                    imageVector =
                        Icons.Outlined.FavoriteBorder,
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

@Composable
private fun navigationColors() =
    NavigationBarItemDefaults.colors(
        selectedIconColor = PrimaryBeige,
        selectedTextColor = PrimaryBeige,
        unselectedIconColor = TextSecondary,
        unselectedTextColor = TextSecondary,
        indicatorColor = CardSecondary
    )

// ==========================================
// DATOS TEMPORALES
// ==========================================

private fun demoHistoryItems(): List<HistoryItem> {

    return listOf(
        HistoryItem(
            id = 1,
            title = "Outfit casual",
            date = "Hoy",
            description =
                "Camiseta + pantalón + tenis"
        ),

        HistoryItem(
            id = 2,
            title = "Outfit favorito",
            date = "Ayer",
            description =
                "Camisa + pantalón + zapatos"
        ),

        HistoryItem(
            id = 3,
            title = "Combinación #3",
            date = "07 nov.",
            description =
                "Camiseta + chaqueta + pantalón"
        )
    )
}