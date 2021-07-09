package br.com.jfb.bytebank.test

import br.com.jfb.bytebank.exceptions.SaldoInsuficienteException

fun funcao1() {
  println("início funcao1")
  try {
    funcao2()
  } catch (e: SaldoInsuficienteException) {
    println("Mensagem exception: ${e.message}")
    println("StackTrace: ${e.stackTrace}")
    println("ERRO de SaldoInsuficienteException")
    println("Causa: ${e.cause}")

    // A PrintStackTrace imprime as três informações acima
    println("PrintStackTrace: ${e.printStackTrace()}")
  }
  println("fim funcao1")
}

fun funcao2() {
  println("início funcao2")
  for (i in 1..5) {
    println(i)
    throw SaldoInsuficienteException()
  }
  println("fim funcao2")
}
