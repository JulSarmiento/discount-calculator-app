package com.julhdev.discountcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.julhdev.discountcalculator.ui.theme.DiscountCalculatorTheme
import com.julhdev.discountcalculator.viewModels.CalculateViewModel1
import com.julhdev.discountcalculator.views.HomeView

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val viewModel : CalculateViewModel1 by viewModels()
    setContent {
      DiscountCalculatorTheme {
        HomeView(viewModel)
      }
    }
  }
}

