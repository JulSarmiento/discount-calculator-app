package com.julhdev.discountcalculator.models

/**
 * Estado de la pantalla de cálculo de descuento.
 * @property price Precio original como String.
 * @property discount Porcentaje de descuento como String.
 * @property discountedPrice Precio con descuento calculado como Double.
 * @property discountAmount Monto del descuento calculado como Double.
 * @property showAlert Indica si se debe mostrar una alerta (por ejemplo, para errores de entrada).
 */
data class CalculateModelState(
  val price: String = "",
  val discount: String = "",
  val discountedPrice: Double = 0.0,
  val discountAmount: Double = 0.0,
  val showAlert: Boolean = false
)
