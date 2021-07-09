package br.com.jfb.bytebank.test.arrays

fun testeAgregacao() {
  /**
   * RANGE
   *
   * Podemos navegar por um array usando a instrução Range
   * */
  val series: IntRange = 1.rangeTo(10)
  for (serie in series) {
    // De um a dez:
    print("$serie, ")
  }

  // Usando operador dois pontos (..) para ir de 0 a cem e o "step" para pular de 2 em dois
  println()
  val intRange = 0..50 step 2
  for (numPar in intRange) {
    // De 0 a cem:
    print("$numPar, ")
  }

  // Interação reversa onde o "it" representa casa um dos números da serie
  println()
  val deCemAtezero = 50 downTo 0 step 2
  deCemAtezero.forEach { print("$it ") }

  // Verificando se algum valor está dentro do intervalo
  println()
  val determinadoIntervalo = 1500.0..5000.0
  val salario = 0000.90
  if (salario in determinadoIntervalo) {
    println("Está dentro do intervalo")
  } else {
    println("Não está dentro do intervalo")
  }

  val intervaloDeLetras = 'a'..'z'
  val letraV = '1'
  println(
    if (letraV in intervaloDeLetras) {
      "Está dentro de a até z"
    } else "Não está dentro de a até z"
  )

  // TESTE DE AGREGAÇÃO VIDEO DOIS ALURA
  /**
   * A operação de verificar um valor maximo dentro de um array
   * é uma operação muito recorrente que foi criado um forma mais simples
   * que é usando o operador max(), porém foi deprecated :(. Mas podemos usar o
   * "maxOrNull() no lugar que aparentemente tem o mesmo efeito"
   * DOCUMENTAÇÃO: "Returns the largest element or null if there are no elements."
   * */
  val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
  val maiorIdade = idades.maxOrNull()
  val idadeMinima = idades.minOrNull()
  println("Idade Maxima: $maiorIdade")
  println("Idade Minima: $idadeMinima")

  // Verificando a média com average
  val mediaIdades = idades.average()
  println("Média das idades: $mediaIdades")

  // Verifica uma condição com all
  val maiorDeIdade = idades.all { it >= 18 }
  if (maiorDeIdade) {
    println("Todos são maiores de idade")
  } else
    println("Nem todos são maiores de idade")

  // Verificando se pelo menos um satisfaz a condição com o any
  val temPeloMenosUmMaiorDeIdade = idades.any { it >= 18 }
  if (temPeloMenosUmMaiorDeIdade) {
    println("Tem pelo menos um maior de idade")
  }

  // Filtra uma lista com uma condição pre determinada
  val todosValoresMaiorQue18 = idades.filter { it >= 18 }
  println("Maiores que 18: $todosValoresMaiorQue18")

  // Encontra na lista um valor "find{}"
  val idadeIgualA18 = idades.find { it == 18 }
  println("Idade igual a $idadeIgualA18")
}