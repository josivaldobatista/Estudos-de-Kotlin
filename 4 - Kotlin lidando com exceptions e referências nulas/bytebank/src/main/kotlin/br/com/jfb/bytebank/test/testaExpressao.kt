package br.com.jfb.bytebank.test

import java.lang.ArithmeticException
import java.lang.NumberFormatException

fun testaExpressao() {
  val entrada: String = "1.0"
  val valorRecebido: Double? = try {
    entrada.toDouble()
  } catch (e: NumberFormatException) {
    println("Erro na conversão")
    e.printStackTrace()
    null
  }
  val valorComTaxa: Double = if (valorRecebido != null) { // ?
    valorRecebido + 0.1
  } else {
    // Podemos colocar um valor padrão em vez de null como está abaixo
    // Veja o exemplo acima
    0.0
    //  Em vez null
  }

  if (valorComTaxa != null) {
    println("Valor recebido: $valorComTaxa")
  } else {
    println("Valor invalido: $valorComTaxa")
  }
  try {
    10 / 0
  } catch (e: ArithmeticException) {
    println("A ERRO de ArithmeticException.class")
  }
}