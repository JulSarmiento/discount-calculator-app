package com.julhdev.discountcalculator.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
  primary = Primary,
  onPrimary = Background,
  secondary = Secondary,
  tertiary = Secondary70,
  background = Background,
  surface = Background,
  error = Error
)

private val LightColorScheme = lightColorScheme(
  primary = Primary,
  onPrimary = Background,
  secondary = Secondary,
  tertiary = Secondary70,
  background = Background,
  surface = Background,
  error = Error
)

@Composable
fun DiscountCalculatorTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false ,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}