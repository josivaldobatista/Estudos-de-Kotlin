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
}