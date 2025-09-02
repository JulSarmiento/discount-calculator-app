package com.julhdev.discountcalculator.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.julhdev.discountcalculator.R
import com.julhdev.discountcalculator.components.MainBtn
import com.julhdev.discountcalculator.components.MainTextField
import com.julhdev.discountcalculator.components.OutlineBtn
import com.julhdev.discountcalculator.components.SpaceHeight
import com.julhdev.discountcalculator.components.SubTitle
import com.julhdev.discountcalculator.components.TitleVew

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        title = { Text(text = "Discount Calculator", fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary,
          titleContentColor = MaterialTheme.colorScheme.secondary
        ),
        navigationIcon = {
          Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "User",
            tint = MaterialTheme.colorScheme.primary,
          )
        }
      )
    }
  ) {
    ContentHomeView(it)
  }

}

@Composable
fun ContentHomeView(paddingValues: PaddingValues ) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues)
      .padding(vertical = 10.dp)
      .padding(horizontal = 20.dp),
  ) {
    val price by remember { mutableStateOf("") }
    val discount by remember { mutableStateOf("") }

    SpaceHeight(20.dp)
    Column {
      TitleVew(
        name = "Calculadora de Descuentos"
      )
      SpaceHeight(10.dp)
      OutlineBtn(
        text = "Limpiar",
        onClick = { /* TODO */ }
      )
    }
    SpaceHeight(25.dp)
    Column {
      SubTitle(
        text = "Monto inicial"
      )
      MainTextField(
        value = price,
        onValueChange = { /* TODO */ },
        label = "Precio"
      )
      SpaceHeight(10.dp)
      SubTitle(
        text = "Porcentaje de descuento"
      )
      MainTextField(
        value = discount,
        onValueChange = { /* TODO */ },
        label = "Descuento (%)"
      )
      SpaceHeight(20.dp)
      MainBtn(
        text = "Calcular Descuento",
        onClick = { /* TODO */ }
      )
    }
  }
}