package com.julhdev.discountcalculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
        /**
         * Componente de la tarjeta principal que muestra el precio con descuento y el descuento aplicado.
         * @param number El número que representa el precio con descuento y el descuento aplicado.
         * @param modifier Modificador opcional para personalizar el diseño del componente.
         * usage: MainCard(150.0)
         */
fun MainCard(
  discountedPrice: Double,
  discountedAmmout: Double,
  modifier: Modifier = Modifier
){
  Card(
    modifier = modifier,
    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.background,
    ),
  ) {
    Column(
      verticalArrangement = Arrangement.Center,
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 30.dp),
    ) {
      Text(
        text = "Precio con descuento",
      )
      SpaceHeight(10.dp)
      Text(
        text = "$ $discountedPrice",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 35.sp,
      )
      SpaceHeight(10.dp)
      HorizontalDivider(
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.background
      )
      SpaceHeight(20.dp)
      Text(
        text = "Descuento aplicado",
      )
      SpaceHeight(10.dp)
      Text(
        text = "$ $discountedAmmout",
        style = MaterialTheme.typography.headlineMedium
      )
    }
  }

}