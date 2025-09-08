package com.julhdev.discountcalculator.viewModels

import kotlin.math.round
import androidx.lifecycle.ViewModel

class CalculateViewModel1: ViewModel() {

  fun calculate(
    price: String,
    discount: String
  ): Pair<Double, Pair<Double, Boolean>> {
    var discountAmount = 0.0
    var discountedPrice = 0.0
    var showAlert = false

    if( price.isEmpty() || discount.isEmpty()){
      showAlert = true
    }
    discountAmount =
      calculateSave(price.toDouble(), discount.toDouble())
    discountedPrice =
      calculateDiscount(price.toDouble(), discount.toDouble())

    return Pair(discountedPrice, Pair(discountAmount, showAlert))
  }

  /**
   * Calcula el precio final después de aplicar un descuento.
   *
   * @param price El precio original.
   * @param discount El porcentaje de descuento a aplicar.
   * @return El precio con descuento redondeado a 2 decimales.
   */
  private fun calculateDiscount(
    price: Double,
    discount: Double,
  ): Double {
    val finalPrice = price - calculateSave(price, discount)
    return (round(finalPrice * 100) / 100)
  }

  /**
   * Calcula la cantidad de dinero que se ahorra con un descuento.
   *
   * @param price El precio original.
   * @param discount El porcentaje de descuento a aplicar.
   * @return La cantidad de dinero ahorrada redondeada a 2 decimales.
   */
  private fun calculateSave(
    price: Double,
    discount: Double,
  ): Double {
    val save = price * (discount / 100)
    return (round(save * 100) / 100)
  }
}