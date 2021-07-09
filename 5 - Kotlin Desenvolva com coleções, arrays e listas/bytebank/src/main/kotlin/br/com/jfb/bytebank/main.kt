package br.com.jfb.bytebank

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

  val nomes = stringArrayOf("Valdo Batista", "Josiane Silva", "Bob Brown")
  println("Lista de nomes: ${nomes.contentToString()}")

  /**
   * Como o BigDecimal não tem a facilidade que os outros primitivos tem
   * que é ter uma forma de criar lista de tipois temos que fazelo "manualmente".
   * Veja abaixo como fazer isso:
   * */
  val salarios = bigDecimalArrayOf("1499.90", "2500.00", "5000.00", "10000.00")
  // Array<BigDecimal>(5) { BigDecimal.ZERO }//<- Temos que iniciar o array com algum elemento "0"
  // salarios[0] = "1500.00".toBigDecimal() <- Para não ter problema de arredondamento, usamos o String para o valor
  // salarios[1] = "2500.00".toBigDecimal()
  println(salarios.contentToString())

  val aumento = "1.1".toBigDecimal()
  val salariosComAumento: Array<BigDecimal> = salarios
    .map { salario ->
      if (salario < "5000.00".toBigDecimal()) {
        salario + "500.00".toBigDecimal()
      } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
      }
    }.toTypedArray()
  println(salariosComAumento.filter { it < "5000.00".toBigDecimal() })

} // <- Fim do main()

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

// Apenas mais um teste
fun stringArrayOf(vararg nomes: String): Array<String> {
  return Array<String>(nomes.size) { i ->
    nomes[i]
  }
}















