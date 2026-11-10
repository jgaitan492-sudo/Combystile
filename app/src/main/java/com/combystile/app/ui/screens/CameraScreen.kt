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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PhotoLibrary
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val CameraBackground = Color(0xFF111A13)
private val CameraCard = Color(0xFF202A21)
private val CameraSecondary = Color(0xFF263128)

private val CameraBeige = Color(0xFFF2D1B8)
private val CameraText = Color(0xFFF6F4EF)
private val CameraMuted = Color(0xFFA9AFA9)
private val CameraDarkText = Color(0xFF29231F)

@Composable
fun CameraScreen(
    onBack: () -> Unit = {},
    onRequestCamera: () -> Unit = {},
    onOpenGallery: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CameraBackground)
            .windowInsetsPadding(WindowInsets.safeDrawing)
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
                    tint = CameraText
                )
            }

            Text(
                text = "Agregar prenda",
                color = CameraText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(45.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(130.dp)
                    .background(
                        CameraCard,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = CameraBeige,
                    modifier = Modifier.size(65.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Text(
                text = "Fotografía tu prenda",
                color = CameraText,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Combystile necesita usar la cámara únicamente cuando decidas fotografiar una prenda.",
                color = CameraMuted,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CameraCard
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    CameraBenefit(
                        text = "La cámara no se activará automáticamente."
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    CameraBenefit(
                        text = "Puedes rechazar el permiso cuando quieras."
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    CameraBenefit(
                        text = "También puedes elegir una foto de la galería."
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = onRequestCamera,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = CameraBeige,
                contentColor = CameraDarkText
            )
        ) {

            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = null
            )

            Text(
                text = "  Activar cámara",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedButton(
            onClick = onOpenGallery,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(15.dp)
        ) {

            Icon(
                imageVector = Icons.Default.PhotoLibrary,
                contentDescription = null,
                tint = CameraBeige
            )

            Text(
                text = "  Elegir de la galería",
                color = CameraBeige,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CameraBenefit(
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(38.dp)
                .background(
                    CameraSecondary,
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = CameraBeige,
                modifier = Modifier.size(21.dp)
            )
        }

        Text(
            text = text,
            modifier = Modifier.padding(start = 12.dp),
            color = CameraMuted,
            fontSize = 13.sp
        )
    }
}
