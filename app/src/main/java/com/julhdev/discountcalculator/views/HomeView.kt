package com.julhdev.discountcalculator.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.julhdev.discountcalculator.viewModels.CalculateViewModel1
import androidx.compose.ui.platform.LocalFocusManager
import com.julhdev.discountcalculator.utils.sanitizePercent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalculateViewModel1) {
  Scaffold(
    modifier = Modifier,
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
    ContentHomeView(it, viewModel)
  }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalculateViewModel1 ) {
  val focusManager = LocalFocusManager.current
  val state = viewModel.state

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .padding(paddingValues),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        SpaceHeight(10.dp)
        TitleVew(name = "Calculadora de Descuentos")
        SpaceHeight(10.dp)
        OutlineBtn(
          text = "Limpiar",
          onClick = { viewModel.reset() }
        )
        SpaceHeight(25.dp)
        SubTitle(text = "Monto inicial")
        MainTextField(
          value = state.price,
          onValueChange = { viewModel.onValue(it, "price") },
          label = "Precio"
        )
        SpaceHeight(10.dp)
        SubTitle(text = "Porcentaje de descuento")
        MainTextField(
          value = state.discount,
          onValueChange = { input ->
            val sanitized = sanitizePercent(input)
            viewModel.onValue(sanitized, "discount")
          },
          label = "Descuento",
          icon = Icons.Default.Percent
        )
        SpaceHeight(20.dp)
        MainBtn(
          text = "Calcular",
          onClick = {
            focusManager.clearFocus()
            viewModel.calculate()
          }
        )

        if (state.showAlert) {
          Alert(
            title = "Error",
            message = "Por favor ingresa un monto y un descuento válido.",
            confirmText = "Aceptar",
            onDismiss = { viewModel.cancelAlter() },
            onConfirm = { viewModel.cancelAlter() }
          )
        }
      }
    }
    item {
      Column(
        modifier = Modifier
          .background(MaterialTheme.colorScheme.tertiary)
          .fillMaxWidth()
          .padding(vertical = 25.dp)
          .padding(horizontal = 15.dp)
      ) {
        TitleVew(
          name = "Resultado",
          color = MaterialTheme.colorScheme.background
        )
        SpaceHeight(5.dp)
        Text(
          text = "Tus resultados se muestran a continuación según la información que ingresaste.",
          color = MaterialTheme.colorScheme.background
        )
        SpaceHeight(20.dp)
        Box {
          MainCard(
            discountedPrice = state.discountedPrice,
            discountedAmmout = state.discountAmount,
            modifier = Modifier
              .fillMaxWidth()
              .wrapContentHeight()
              .padding(5.dp)
          )
        }
      }
    }
  }
  SpaceHeight(40.dp)
}