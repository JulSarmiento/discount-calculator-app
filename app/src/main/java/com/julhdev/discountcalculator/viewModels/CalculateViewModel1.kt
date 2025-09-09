package com.julhdev.discountcalculator.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.math.round
import androidx.lifecycle.ViewModel

/**
 * ViewModel para manejar la lógica de cálculo de descuentos.
 */
class CalculateViewModel1: ViewModel() {

  var price by mutableStateOf("")
    private set

  var discount by mutableStateOf("")
    private set

  var discountedPrice by mutableDoubleStateOf(0.0)
    private set

  var discountAmount by mutableDoubleStateOf(0.0)
    private set

  var showAlert by mutableStateOf(false)
    private set

  /**
   * Actualiza el valor de precio o descuento basado en el texto proporcionado.
   * @param value El nuevo valor a asignar.
   * @param text Indica si el valor es para "price" o "discount".
   * @usage onValue("100", "price") o onValue("15", "discount")
   */
  fun onValue(
    value: String,
    text: String
  ) {
    when(text){
      "price" -> price = value
      "discount" -> discount = value
    }
  }

  /**
   * Realiza el cálculo del precio con descuento y la cantidad ahorrada.
   * Actualiza las variables de estado correspondientes.
   * @param price El precio original como cadena.
   * @param discount El porcentaje de descuento como cadena.
   * @return Una pareja que contiene el precio con descuento y otra pareja con la cantidad ahorrada y un indicador de alerta.
   * @usage calculate()
   */
  fun calculate(
    price: String,
    discount: String
  ): Pair<Double, Pair<Double, Boolean>> {

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

  /**
   * Reinicia todos los valores a sus estados iniciales.
   * @usage reset()
   */
  fun reset() {
    price = ""
    discount = ""
    discountedPrice = 0.0
    discountAmount = 0.0
    showAlert = false
  }

  /**
   * Cancela la alerta estableciendo showAlert a false.
   * @usage cancelAlter()
   */
  fun cancelAlter(){
    showAlert = false
  }
}