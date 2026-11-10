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
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val CombinationBackground = Color(0xFF111A13)
private val CombinationCard = Color(0xFF202A21)
private val CombinationSecondary = Color(0xFF263128)

private val CombinationBeige = Color(0xFFF2D1B8)
private val CombinationText = Color(0xFFF6F4EF)
private val CombinationMuted = Color(0xFFA9AFA9)
private val CombinationDarkText = Color(0xFF29231F)

data class OutfitCombination(
    val id: Int,
    val title: String,
    val description: String,
    val isFavorite: Boolean = false
)

@Composable
fun CombinationsScreen(
    fixedGarmentName: String? = null,
    onSelectFixedGarment: () -> Unit = {},
    onGenerate: (Int) -> Unit = {},
    onToggleFavorite: (OutfitCombination) -> Unit = {}
) {

    var quantity by remember {
        mutableIntStateOf(3)
    }

    val combinations = remember {
        mutableStateListOf(
            OutfitCombination(
                1,
                "Combinación 1",
                "Camiseta + pantalón + tenis"
            ),
            OutfitCombination(
                2,
                "Combinación 2",
                "Camisa + chaqueta + pantalón"
            ),
            OutfitCombination(
                3,
                "Combinación 3",
                "Camiseta + pantalón + zapatos"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CombinationBackground)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Text(
            text = "Combinaciones",
            color = CombinationText,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            text = "Crea nuevos outfits con tus prendas",
            color = CombinationMuted,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = CombinationCard
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "Cantidad de combinaciones",
                    color = CombinationText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = {
                            if (quantity > 1) {
                                quantity--
                            }
                        },
                        modifier = Modifier
                            .size(46.dp)
                            .background(
                                CombinationSecondary,
                                CircleShape
                            )
                    ) {

                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Disminuir",
                            tint = CombinationBeige
                        )
                    }

                    Text(
                        text = quantity.toString(),
                        modifier = Modifier.padding(
                            horizontal = 30.dp
                        ),
                        color = CombinationText,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = {
                            if (quantity < 10) {
                                quantity++
                            }
                        },
                        modifier = Modifier
                            .size(46.dp)
                            .background(
                                CombinationSecondary,
                                CircleShape
                            )
                    ) {

                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Aumentar",
                            tint = CombinationBeige
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Puedes solicitar entre 1 y 10 combinaciones.",
                    modifier = Modifier.fillMaxWidth(),
                    color = CombinationMuted,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(14.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onSelectFixedGarment()
                },
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = CombinationCard
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
                        .size(52.dp)
                        .background(
                            CombinationSecondary,
                            RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Checkroom,
                        contentDescription = null,
                        tint = CombinationBeige
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 14.dp)
                ) {

                    Text(
                        text = "Prenda fija",
                        color = CombinationText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = fixedGarmentName
                            ?: "Selecciona una prenda opcional",
                        color = CombinationMuted,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = {
                onGenerate(quantity)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = CombinationBeige,
                contentColor = CombinationDarkText
            )
        ) {

            Icon(
                imageVector = Icons.Default.Checkroom,
                contentDescription = null
            )

            Text(
                text = "  Generar $quantity combinaciones",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Text(
            text = "Resultados",
            color = CombinationText,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        combinations.forEachIndexed { index, combination ->

            CombinationCard(
                combination = combination,
                onToggleFavorite = {

                    combinations[index] =
                        combination.copy(
                            isFavorite =
                                !combination.isFavorite
                        )

                    onToggleFavorite(
                        combinations[index]
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}

@Composable
private fun CombinationCard(
    combination: OutfitCombination,
    onToggleFavorite: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = CombinationCard
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(62.dp)
                    .background(
                        CombinationSecondary,
                        RoundedCornerShape(17.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Checkroom,
                    contentDescription = null,
                    tint = CombinationBeige,
                    modifier = Modifier.size(31.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp)
            ) {

                Text(
                    text = combination.title,
                    color = CombinationText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = combination.description,
                    color = CombinationMuted,
                    fontSize = 12.sp
                )
            }

            IconButton(
                onClick = onToggleFavorite
            ) {

                Icon(
                    imageVector =
                        if (combination.isFavorite) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Outlined.FavoriteBorder
                        },
                    contentDescription =
                        if (combination.isFavorite) {
                            "Quitar de favoritos"
                        } else {
                            "Agregar a favoritos"
                        },
                    tint = CombinationBeige
                )
            }
        }
    }
}