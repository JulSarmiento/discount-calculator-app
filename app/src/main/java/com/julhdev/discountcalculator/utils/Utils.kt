package com.julhdev.discountcalculator.utils
import android.icu.text.DecimalFormat
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Formato para valores numéricos con separadores de miles.
 * Ejemplo: 1234567 -> "1,234,567"
 * @usage formatValue.format(1234567)
 */
val formatValue = DecimalFormat("###,###,###")

/**
 * Normaliza una entrada de porcentaje, permite números (con decimal opcional),
 * convierte comas a puntos, parsea seguro, y devuelve un valor clamped entre 0 y 100.
 * Devuelve cadena vacía si la entrada está vacía.
 */
fun sanitizePercent(input: String): String {
  val trimmed = input.trim()
  if (trimmed.isEmpty()) return ""

  val cleaned = trimmed.replace("[^0-9,\\.]".toRegex(), "")
  if (cleaned.isEmpty()) return ""

  val normalized = cleaned.replace(',', '.')
  val value = normalized.toDoubleOrNull() ?: return ""
  val clamped = when {
    value.isNaN() -> 0.0
    value < 0.0 -> 0.0
    value > 100.0 -> 100.0
    else -> value
  }
  return try {
    BigDecimal.valueOf(clamped).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString()
  } catch (e: Exception) {
    clamped.toString()
  }
}