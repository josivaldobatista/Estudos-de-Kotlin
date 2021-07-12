package br.com.jfb.bytebank.utils

import java.math.BigDecimal

/**
 * this é proprio array de BigDecimal
 * valor é o elemento do array que estamos interando (cada elemento)
 * acumaldor é a somatoria de cada interação
 * */
fun Array<BigDecimal>.somatoria(): BigDecimal {
  return this.reduce { acumulador, valor -> // <- O reduce reduz um array somando todos os elementos
    acumulador + valor // <- podemos fazer qualquer operação aqui dentro
  }
}

/**
 * Perceba que fazer isso todas as vezes é um pouco trabalhoso e como não temos
 * a facilidade e usar os tipos primitivos, temos que usar uma forma um pouco mais
 * "dificil" criando uma função para tal
 * */
fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> { //<- Os vararg serve para criar um conjunto de algum tipo
  // Podemos ter 1 elemento ou 20 elementos dentro do vararg
  return Array<BigDecimal>(valores.size) { i ->
    valores[i].toBigDecimal()
  }
}

fun Array<BigDecimal>.media(): BigDecimal {
  return if (this.isEmpty()) {
    BigDecimal.ZERO
  } else {
    this.somatoria() / this.size.toBigDecimal()
  }
}