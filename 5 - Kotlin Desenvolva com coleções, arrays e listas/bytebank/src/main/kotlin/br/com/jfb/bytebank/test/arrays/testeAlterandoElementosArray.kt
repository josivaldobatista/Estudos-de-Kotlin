package br.com.jfb.bytebank.test.arrays

fun testeAlterandoElementosArray() {
  /**
   * Para criar Arrays de outros tipos precisamos usar a função que
   * seja do tipo que iremos declarar as nossas variaveis, no exemplo abaixo
   * é um array de Double por isso usei doubleArrayOf.
   * */
  val salarios = doubleArrayOf(1500.00, 2300.00, 5000.00, 8000.00, 10000.00)
  val aumento = 1.1

  /*
  * Para incrementar um valor de cada indice. (manual e com problemas)
  * */
  var indice = 0
  for (salario in salarios) {
    salarios[indice] = salario * aumento
    indice++
  }
  println(salarios.contentToString())

  /**
   * Para incrementar um valor para cada indice de maneira com poucas
   * falhas usando o indices do array. Veja abaixo
   * */
  for (salario in salarios.indices) {
    salarios[salario] = salarios[salario] + 1000.00
  }
  println("Salarios com bonos de 1000:  ${salarios.contentToString()}")

  /**
   * O código abaixo é uma variação do código acima para fazer o calculo
   * usando o indice interando em casa valor do array onde o "i" é o indice do array
   * o o salário é valor de cada posição.
   * */
  salarios.forEachIndexed { i, salario ->
    salarios[i] = salario + 2000
  }
  println("Salarios com bonos de 2000:  ${salarios.contentToString()}")

  println("*** NOMES ***")
  val nomes = mutableListOf("Valdo Batista", "Bob Back", "Maria White", "Abe")
  nomes.add("Fran Yellow")
  nomes.forEach { nome ->
    println(nome)
  }

  val contatos = arrayOf("Roberto", "Ana", "Paula")
  contatos.forEach { contato ->
    println("CONTATOS: $contato")
  }

  contatos.forEachIndexed { i, contato ->
    println("CONTATO POSIÇÃO " + (i + 1) + ": $contato")
  }
}