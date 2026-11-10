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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val GarmentBackground = Color(0xFF111A13)
private val GarmentCard = Color(0xFF202A21)
private val GarmentSecondary = Color(0xFF263128)
private val GarmentBorder = Color(0xFF334036)

private val GarmentBeige = Color(0xFFF2D1B8)
private val GarmentText = Color(0xFFF6F4EF)
private val GarmentMuted = Color(0xFFA9AFA9)
private val GarmentDarkText = Color(0xFF29231F)

private val garmentTypes = listOf(
    "Superior",
    "Inferior",
    "Calzado",
    "Abrigo",
    "Accesorio"
)

@Composable
fun NewGarmentScreen(
    onBack: () -> Unit = {},
    onRepeatPhoto: () -> Unit = {},
    onSaveGarment: (
        name: String,
        type: String,
        color: String
    ) -> Unit = { _, _, _ -> }
) {

    var name by remember {
        mutableStateOf("")
    }

    var color by remember {
        mutableStateOf("")
    }

    var selectedType by remember {
        mutableStateOf("")
    }

    val canSave =
        name.isNotBlank() &&
                color.isNotBlank() &&
                selectedType.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GarmentBackground)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

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
                    tint = GarmentText
                )
            }

            Text(
                text = "Nueva prenda",
                color = GarmentText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = GarmentCard
            )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(GarmentSecondary),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        imageVector = Icons.Default.Checkroom,
                        contentDescription = "Fotografía de la prenda",
                        tint = GarmentBeige,
                        modifier = Modifier.size(80.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Vista previa de la fotografía",
                        color = GarmentMuted,
                        fontSize = 13.sp
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        Text(
            text = "Nombre de la prenda",
            color = GarmentMuted,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Ejemplo: Camiseta negra",
                    color = GarmentMuted
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = GarmentText,
                unfocusedTextColor = GarmentText,
                focusedContainerColor = GarmentCard,
                unfocusedContainerColor = GarmentCard,
                focusedBorderColor = GarmentBeige,
                unfocusedBorderColor = GarmentBorder,
                cursorColor = GarmentBeige
            )
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = "Color principal",
            color = GarmentMuted,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        OutlinedTextField(
            value = color,
            onValueChange = {
                color = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Ejemplo: Negro",
                    color = GarmentMuted
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = GarmentText,
                unfocusedTextColor = GarmentText,
                focusedContainerColor = GarmentCard,
                unfocusedContainerColor = GarmentCard,
                focusedBorderColor = GarmentBeige,
                unfocusedBorderColor = GarmentBorder,
                cursorColor = GarmentBeige
            )
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        Text(
            text = "¿Qué tipo de prenda es?",
            color = GarmentText,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        garmentTypes
            .chunked(2)
            .forEach { rowTypes ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    rowTypes.forEach { type ->

                        GarmentTypeCard(
                            modifier = Modifier.weight(1f),
                            type = type,
                            selected = selectedType == type,
                            onClick = {
                                selectedType = type
                            }
                        )
                    }

                    if (rowTypes.size == 1) {
                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedButton(
            onClick = onRepeatPhoto,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp)
        ) {

            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = null,
                tint = GarmentBeige
            )

            Text(
                text = "  Repetir fotografía",
                color = GarmentBeige,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                onSaveGarment(
                    name.trim(),
                    selectedType,
                    color.trim()
                )
            },
            enabled = canSave,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GarmentBeige,
                contentColor = GarmentDarkText,
                disabledContainerColor = GarmentSecondary,
                disabledContentColor = GarmentMuted
            )
        ) {

            Icon(
                imageVector = Icons.Default.Save,
                contentDescription = null
            )

            Text(
                text = "  Guardar prenda",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )
    }
}

@Composable
private fun GarmentTypeCard(
    modifier: Modifier,
    type: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(78.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected) {
                    GarmentBeige
                } else {
                    GarmentCard
                }
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Default.Checkroom,
                contentDescription = null,
                tint =
                    if (selected) {
                        GarmentDarkText
                    } else {
                        GarmentBeige
                    }
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = type,
                color =
                    if (selected) {
                        GarmentDarkText
                    } else {
                        GarmentText
                    },
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}