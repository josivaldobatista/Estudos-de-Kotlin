package br.com.jfb.bytebank.models

abstract class Conta(
  var titular: Cliente,
  val numero: Int
) {

  var saldo = 0.0
    protected set

  //  var totalContasCriadas = 0
  // PARA USAR VARIAVEIS GLOBAIS
  companion object {
    var total = 0
      private set
  }

  init {
    println("PLUS conta")
    total++
  }

  fun deposita(valorDeposito: Double) {
    if (valorDeposito > 0) {
      this.saldo += valorDeposito
      println("Depositando na conta do(a) $titular")
    }
  }

  abstract fun sacar(valorSacar: Double)

  fun transferencia(contaDestino: Conta, valor: Double): Boolean {
    if (saldo >= valor) {
      sacar(valor)
      contaDestino.deposita(valor)
      return true
    }
    return false
  }
}

class ContaCorrente(
  titular: Cliente,
  numero: Int
) : Conta(
  titular = titular,
  numero = numero
) {
  override fun sacar(valorSacar: Double) {
    val valorComTaxa = valorSacar + 0.1
    if (this.saldo >= valorComTaxa) {
      this.saldo -= valorComTaxa
    }
  }
}

class ContaPoupanca(
  titular: Cliente,
  numero: Int
) : Conta(
  titular = titular,
  numero = numero
) {
  override fun sacar(valorSacar: Double) {
    if (this.saldo >= valorSacar) {
      this.saldo -= valorSacar
    }
  }
}