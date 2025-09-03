package com.julhdev.discountcalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.*


@Composable
        /**
         * Componente del título principal.
         * @param name El texto que se mostrará como título.
         * usage: TitleVew("Bienvenido")
         */
fun TitleVew(name: String, color: Color = MaterialTheme.colorScheme.primary) {
  Text(
    text = name,
    fontSize = 23.sp,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Start,
    color = color,
  )
}

@Composable
        /**
         * Componente del subtítulo.
         * @param text El texto que se mostrará como subtítulo.
         * usage: SubTitle("Este es un subtítulo")
         */
fun SubTitle(text: String) {
  Text(
    text = text,
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium,
    textAlign = TextAlign.Start,
    color = MaterialTheme.colorScheme.tertiary,
  )
}

@Composable
        /**
         * Componente para agregar espacio vertical
         * @param size El tamaño del espacio vertical (por defecto es 10.dp)
         * usage: SpaceHeight(20.dp) o SpaceHeight() para el valor por defecto
         */
fun SpaceHeight(size: Dp = 10.dp) {
  Spacer(modifier = Modifier
    .height(size)
  )
}

@Composable
        /**
         * Componente para agregar espacio horizontal
         * @param size El tamaño del espacio horizontal (por defecto es 10.dp)
         * usage: SpaceWidth(20.dp) o SpaceWidth() para el valor por defecto
         */
fun SpaceWidth(size: Dp = 10.dp) {
  Spacer(modifier = Modifier
    .width(size)
  )
}

@Composable
        /**
         * Componente de campo de texto principal.
         * @param value El valor actual del campo de texto.
         * @param onValueChange La función que se llama cuando el valor del campo de texto
         * cambia.
         * @param label La etiqueta que se muestra dentro del campo de texto.
         * usage: MainTextField(value = text, onValueChange = { text = it }, label = "Ingrese texto")
         */
fun MainTextField(
  value: String,
  onValueChange: (String) -> Unit,
  label: String,
  icon: ImageVector = Icons.Default.AttachMoney,
) {
  OutlinedTextField(
    value= value,
    leadingIcon = {
     Box(
       modifier = Modifier
         .size(50.dp)
         .background(
            color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f),
            shape = RoundedCornerShape(4.dp)
         ),
         contentAlignment = Alignment.Center
     ){
       Icon(
         imageVector = icon,
         contentDescription = "Money icon",
         tint = MaterialTheme.colorScheme.tertiary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ,

         )
     }
    },
    onValueChange = onValueChange,
    label = { Text(text = label) },
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Number
    ),

    modifier = Modifier
      .fillMaxWidth()
      .padding(0.dp)
  )
}

@Composable
        /**
         * Componente del botón principal.
         * @param text El texto que se mostrará en el botón.
         * @param color El color de fondo del botón (por defecto es el color secundario del tema).
         * @param onClick La acción a realizar cuando se haga clic en el botón.
         * usage: MainBtn("Enviar", Color.Blue) { /* Acción */ }
         */
fun MainBtn(
  text: String,
  color: Color = MaterialTheme.colorScheme.secondary,
  onClick: () -> Unit
) {
  OutlinedButton(
    onClick = onClick,
    colors = ButtonDefaults.outlinedButtonColors(
      containerColor = color,
    ),
    border = null,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Icon(
      imageVector = Icons.Default.Calculate,
      contentDescription = "Money icon",
      tint = MaterialTheme.colorScheme.primary,
    )
    SpaceWidth(10.dp)
    Text(
      text = text,
      fontSize = 20.sp,
    )
  }
}

@Composable
fun OutlineBtn(
  text: String,
  onClick: () -> Unit
) {
  Text(
    text = text,
    style = TextStyle(
      fontSize = 16.sp,
      textDecoration = TextDecoration.Underline
    ),
    color = MaterialTheme.colorScheme.tertiary,
    modifier = Modifier.clickable { onClick() }
  )
}