package com.julhdev.discountcalculator.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

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