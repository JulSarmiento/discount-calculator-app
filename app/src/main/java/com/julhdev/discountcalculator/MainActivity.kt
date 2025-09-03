package com.julhdev.discountcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.julhdev.discountcalculator.ui.theme.DiscountCalculatorTheme
import com.julhdev.discountcalculator.views.HomeView

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DiscountCalculatorTheme {
        HomeView()
      }
    }
  }
}

