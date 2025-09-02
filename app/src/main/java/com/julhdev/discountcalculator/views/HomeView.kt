package com.julhdev.discountcalculator.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.julhdev.discountcalculator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        title = { Text(text = "Discount Calculator", fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.secondary,
          titleContentColor = MaterialTheme.colorScheme.primary
        )
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
      .padding(paddingValues)
      .padding(10.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      modifier = Modifier.fillMaxSize(),
      painter = painterResource(id = R.drawable.image),
      contentDescription = "Background"
    )
  }
}