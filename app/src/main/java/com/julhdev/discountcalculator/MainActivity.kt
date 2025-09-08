package com.julhdev.discountcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.julhdev.discountcalculator.ui.theme.DiscountCalculatorTheme
import com.julhdev.discountcalculator.viewModels.CalculateViewModel1
import com.julhdev.discountcalculator.views.HomeView
import kotlin.getValue

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    val viewModel : CalculateViewModel1 by viewModels()
    setContent {
      DiscountCalculatorTheme {
        HomeView(viewModel)
      }
    }
  }
}

