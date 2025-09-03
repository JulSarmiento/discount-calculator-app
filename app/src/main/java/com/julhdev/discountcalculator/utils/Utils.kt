package com.julhdev.discountcalculator.utils

import kotlin.math.round

/**
 * Calcula el precio final después de aplicar un descuento.
 *
 * @param price El precio original.
 * @param discount El porcentaje de descuento a aplicar.
 * @return El precio con descuento redondeado a 2 decimales.
 */
fun calculateDiscount(
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
fun calculateSave(
  price: Double,
  discount: Double,
): Double {
  val save = price * (discount / 100)
  return (round(save * 100) / 100)
}