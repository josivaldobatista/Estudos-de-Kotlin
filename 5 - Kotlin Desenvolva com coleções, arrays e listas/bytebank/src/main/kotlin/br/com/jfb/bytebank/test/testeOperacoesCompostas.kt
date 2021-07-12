package br.com.jfb.bytebank.test

import br.com.jfb.bytebank.utils.bigDecimalArrayOf
import br.com.jfb.bytebank.utils.media
import br.com.jfb.bytebank.utils.somatoria
import java.math.BigDecimal
import java.math.RoundingMode

fun testeOperaçõesCompostas() {
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
    .map { salario -> calculaAumentoRelativo(salario, aumento) }.toTypedArray()
  println(salariosComAumento.filter { it < "5000.00".toBigDecimal() })

  val gastoInicial = salariosComAumento.somatoria()
  println("Gasto inicial: $gastoInicial")

  /**
   * O fold é bem parecido com o reduce com a diferença que recebe um valor inicial
   * */
  val meses = 6.toBigDecimal()
  val gastoTotal = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
    acumulador + (salario * meses).setScale(2, RoundingMode.UP)
  }
  println("Gasto total 6 meses: $gastoTotal")

  /**
   * Precisamos saber a média dos três primeiros salários e para fazer isso,
   * vamos precisar ordernar-los. Veja abaixo:
   *
   * O tresUltimosSalarios devolve uma List e vou usar a converção "toTypedArray"
   * para devolver um array de BigDecimal
   * */
  val salariosOrdenados = salariosComAumento.sorted() // <- Ordenando os salários do menor para maior default
  val tresUltimosSalarios: Array<BigDecimal> =
    salariosOrdenados.takeLast(3) // <- pegando os 3 ultimos salarios da ordenação acima
      .toTypedArray() //<- Convertendo para array de bigDecimal

  println("Tres ultimos salários: " + tresUltimosSalarios.contentToString())

  val media = tresUltimosSalarios.media()
  println("Média final: $media")

  /**
   * Perceba que ficar calculando uma linha abaixo da outra não está errado
   * mas podemos melhorar esse código deixando mais com a cara do kotlin.
   *
   * Esse tipo de abordagem é bom pois não precisamos guarda os resultados
   * como a  média ou outro calculo em alguma variavel como fizemos acima, precisamos
   * sim apenas do resultado.
   *
   * Veja abaixo como fizemos o mesmo código acima para ficar com a cara de kotlin:
   * */

  val mediaResumida = salariosComAumento
    .sorted() //<- ordenando
    .takeLast(3) //<- pegando os tres ultimos
    .toTypedArray()//<- convertendo para array pois retorna um List<>
    .media() //<- Finalmente calculando a média
  println("Média com cara de kotlin: $mediaResumida") // <- mesmo resultado

  val mediaMenoresSalarios = salariosComAumento
    .sorted()
    .take(3)
    .toTypedArray()
    .media()
  println("Média menores salarios: $mediaMenoresSalarios")

  val notas = intArrayOf(7, 5, 8, 9)
  val mediaIntArray = notas.sorted().takeLast(3).average()
  println(mediaIntArray)
}

private fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal) =
  if (salario < "5000.00".toBigDecimal()) {
    salario + "500.00".toBigDecimal()
  } else {
    (salario * aumento).setScale(2, RoundingMode.UP)
  }

// Apenas mais um teste
fun stringArrayOf(vararg nomes: String): Array<String> {
  return Array<String>(nomes.size) { i ->
    nomes[i]
  }
}