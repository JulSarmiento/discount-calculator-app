package com.julhdev.discountcalculator.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.julhdev.discountcalculator.components.Alert
import com.julhdev.discountcalculator.components.MainBtn
import com.julhdev.discountcalculator.components.MainCard
import com.julhdev.discountcalculator.components.MainTextField
import com.julhdev.discountcalculator.components.OutlineBtn
import com.julhdev.discountcalculator.components.SpaceHeight
import com.julhdev.discountcalculator.components.SubTitle
import com.julhdev.discountcalculator.components.TitleVew
import com.julhdev.discountcalculator.utils.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = "Descuentos-chan", fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary,
          titleContentColor = MaterialTheme.colorScheme.secondary
        ),
        navigationIcon = {
          Icon(
            imageVector = Icons.Filled.Percent,
            contentDescription = "User",
            tint = MaterialTheme.colorScheme.secondary,
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
  var price by remember { mutableStateOf("") }
  var discount by remember { mutableStateOf("") }
  var discountedPrice by remember { mutableStateOf(0.0) }
  var discountAmount by remember { mutableStateOf(0.0) }
  var showAlert by remember { mutableStateOf(false) }

   Column(
     modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally,
   ) {
     Column(
       modifier = Modifier
         .fillMaxWidth()
         .padding(paddingValues)
         .padding(vertical = 10.dp)
         .padding(horizontal = 20.dp),

       ) {
       SpaceHeight(20.dp)
       Column {
         TitleVew(
           name = "Calculadora de Descuentos"
         )
         SpaceHeight(10.dp)
         OutlineBtn(
           text = "Limpiar",
           onClick = {
              price = ""
              discount = ""
              discountedPrice = 0.0
              discountAmount = 0.0
           }
         )
       }
       SpaceHeight(25.dp)
       Column {
         SubTitle(
           text = "Monto inicial"
         )
         MainTextField(
           value = price,
           onValueChange = { price = it },
           label = "Precio"
         )
         SpaceHeight(10.dp)
         SubTitle(
           text = "Porcentaje de descuento"
         )
         MainTextField(
           value = discount,
           onValueChange = { discount = it },
           label = "Descuento",
           icon = Icons.Default.Percent
         )
         SpaceHeight(20.dp)
         MainBtn(
           text = "Calcular",
           onClick = {
             if( price.isEmpty() || discount.isEmpty()){
               showAlert = true
               return@MainBtn
             }

             discountAmount = calculateSave(price.toDouble(), discount.toDouble())
             discountedPrice =calculateDiscount(price.toDouble(), discount.toDouble())
           }
         )

         if(showAlert) {
           Alert(
             title = "Error",
             message = "Por favor, complete todos los campos.",
             confirmText = "Aceptar",
             onDismiss = { showAlert = false },
             onConfirm = { showAlert = false }
           )
         }
       }
     }
     Column(
       modifier = Modifier
         .background(MaterialTheme.colorScheme.tertiary)
         .fillMaxWidth()
         .padding( 15.dp),
     ) {
       TitleVew(
          name = "Resultado",
         color = MaterialTheme.colorScheme.background
       )
       SpaceHeight(5.dp)
       Text(
          text = "Tus resultados se muestran a continuación según la información que ingresaste."
       )
       SpaceHeight(10.dp)
       Box(
       ){
         MainCard(
           discountedPrice = discountedPrice,
           discountedAmmout = discountAmount,
           modifier = Modifier
             .fillMaxSize()
             .padding(5.dp)
         )
       }
     }
   }
}