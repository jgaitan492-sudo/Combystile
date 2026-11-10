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
import androidx.compose.material.icons.filled.Favorite
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

private val FavBackground = Color(0xFF111A13)
private val FavCard = Color(0xFF202A21)
private val FavCardSecondary = Color(0xFF263128)
private val FavNavigation = Color(0xFF182019)

private val FavBeige = Color(0xFFF2D1B8)
private val FavText = Color(0xFFF6F4EF)
private val FavSecondaryText = Color(0xFFA9AFA9)
private val FavDarkText = Color(0xFF29231F)

data class FavoriteOutfit(
    val id: Int,
    val title: String,
    val description: String
)

@Composable
fun FavoritesScreen(
    favorites: List<FavoriteOutfit> = demoFavorites(),
    onRemoveFavorite: (FavoriteOutfit) -> Unit = {},
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
            .background(FavBackground)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text = "Favoritos",
                        color = FavText,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Tus combinaciones guardadas",
                        color = FavSecondaryText,
                        fontSize = 13.sp
                    )
                }

                IconButton(
                    onClick = onProfile,
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            FavCard,
                            CircleShape
                        )
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil",
                        tint = FavBeige
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            if (favorites.isEmpty()) {

                EmptyFavorites()

            } else {

                favorites.forEach { favorite ->

                    FavoriteCard(
                        outfit = favorite,
                        onRemoveFavorite = {
                            onRemoveFavorite(favorite)
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )
                }
            }
        }

        FavoritesBottomBar(
            onHome = onHome,
            onHistory = onHistory,
            onCamera = onCamera,
            onCombinations = onCombinations,
            onFavorites = onFavorites
        )
    }
}

@Composable
private fun FavoriteCard(
    outfit: FavoriteOutfit,
    onRemoveFavorite: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = FavCard
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        FavCardSecondary,
                        RoundedCornerShape(18.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Checkroom,
                    contentDescription = null,
                    tint = FavBeige,
                    modifier = Modifier.size(32.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp)
            ) {

                Text(
                    text = outfit.title,
                    color = FavText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = outfit.description,
                    color = FavSecondaryText,
                    fontSize = 12.sp
                )
            }

            IconButton(
                onClick = onRemoveFavorite
            ) {

                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Quitar de favoritos",
                    tint = FavBeige
                )
            }
        }
    }
}

@Composable
private fun EmptyFavorites() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 90.dp,
                bottom = 90.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(85.dp)
                .background(
                    FavCard,
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                tint = FavBeige,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Aún no tienes favoritos",
            color = FavText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Guarda las combinaciones que más te gusten.",
            color = FavSecondaryText,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun FavoritesBottomBar(
    onHome: () -> Unit,
    onHistory: () -> Unit,
    onCamera: () -> Unit,
    onCombinations: () -> Unit,
    onFavorites: () -> Unit
) {

    NavigationBar(
        containerColor = FavNavigation
    ) {

        NavigationBarItem(
            selected = false,
            onClick = onHome,
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Inicio"
                )
            },
            label = {
                Text("Inicio")
            },
            colors = favoriteNavigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onHistory,
            icon = {
                Icon(
                    Icons.Default.History,
                    contentDescription = "Historial"
                )
            },
            label = {
                Text("Historial")
            },
            colors = favoriteNavigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onCamera,
            icon = {

                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(
                            FavBeige,
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = "Cámara",
                        tint = FavDarkText
                    )
                }
            },
            label = {
                Text("Cámara")
            },
            colors = favoriteNavigationColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onCombinations,
            icon = {
                Icon(
                    Icons.Default.Checkroom,
                    contentDescription = "Combinar"
                )
            },
            label = {
                Text("Combinar")
            },
            colors = favoriteNavigationColors()
        )

        NavigationBarItem(
            selected = true,
            onClick = onFavorites,
            icon = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favoritos"
                )
            },
            label = {
                Text("Favoritos")
            },
            colors = favoriteNavigationColors()
        )
    }
}

@Composable
private fun favoriteNavigationColors() =
    NavigationBarItemDefaults.colors(
        selectedIconColor = FavBeige,
        selectedTextColor = FavBeige,
        unselectedIconColor = FavSecondaryText,
        unselectedTextColor = FavSecondaryText,
        indicatorColor = FavCardSecondary
    )

private fun demoFavorites(): List<FavoriteOutfit> {

    return listOf(
        FavoriteOutfit(
            id = 1,
            title = "Casual favorito",
            description = "Camiseta + pantalón + tenis"
        ),

        FavoriteOutfit(
            id = 2,
            title = "Salida",
            description = "Camisa + chaqueta + pantalón"
        )
    )
}