package br.com.jfb.bytebank.test.arrays


fun testeInterandoPorUmaArray() {
  val idade1 = 25
  val idade2 = 19
  val idade3 = 33
  val idade4 = 40

  /**
   * A verificação abaixo é muito custosa de ser implementada visto que toda
   * vez que tivermos um novo valor teremos que adicionar uma verificação ou um
   * IF e ELSE adicional. temos maneiras mais eficientes de fazer isso.
   * */
  val maiorIdade = if (idade1 > idade2 && idade1 > idade3 && idade1 > idade4) {
    idade1
  } else if (idade2 > idade3 && idade2 > idade4) {
    idade2
  } else if (idade3 > idade4) {
    idade3
  } else {
    idade4
  }
  println("Maior idade com IF e Else é: $maiorIdade")

  /**
   * Para fazer isso vamos usar as ESTRUTURAS DE DADOS para fazer isso. Veja abaixo:
   * */

  val idades = IntArray(4)
  idades[0] = 55
  idades[1] = 60
  idades[2] = 12
  idades[3] = 34

  var maiorIdadeArray = 0
  for (idade in idades) {
    if (idade > maiorIdadeArray) {
      maiorIdadeArray = idade
    }
  }
  println("Maior idade com ARRAY é: $maiorIdadeArray")

  /**
   * Perceba que a implementação com ARRAYS é mais simples que a com
   * IF e ELSE e, caso precise adicionar novos elementos basta apenas ir
   * no array e informa o nome do array e o indece do mesmo.
   * */

  /**
   * INT ARRAY OF
   *
   * É mais facil fazer compração usando um grupo de variaveis com o array
   * mas, no KOTLIN temos uma função que facilita na hora de trabalhar com arrys
   * e indices chamada "INT ARRAY OF". Veja abaixo como funciona:
   * */

  var idadeIntArrayOf = Int.MIN_VALUE
  val idadesIntArrayOf: IntArray = intArrayOf(78, 96, 35, 47, 19)
  for (idade in idadesIntArrayOf) {
    if (idade > idadeIntArrayOf) {
      idadeIntArrayOf = idade
    }
  }

  println("A maior idade do INT ARRAY OF é: $idadeIntArrayOf")

  /**
   * Existe uma outra forma de percorrer um array chamado FOR EACH
   * */

  var menorIdade = Int.MAX_VALUE
  idadesIntArrayOf.forEach { idade -> // <- O forEach é uma função
    if (idade < menorIdade) {
      menorIdade = idade
    }
  }

  println("A menor idade usando o for Each é: $menorIdade")
}
