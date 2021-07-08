package br.com.jfb.bytebank.models

import br.com.jfb.bytebank.exceptions.FalhaAutenticacaoException
import br.com.jfb.bytebank.exceptions.SaldoInsuficienteException

abstract class Conta(
  var titular: Cliente,
  val numero: Int
) : Autenticavel {

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

  fun transferencia(contaDestino: Conta, valor: Double, senha: Int) {
    if (saldo < valor) {
      throw SaldoInsuficienteException(
        mensagem = "Saldo é insuficiente para essa operação, Saldo atual: $saldo"
      )
    }
    if (!autentica(senha)) {
      throw FalhaAutenticacaoException()
    }
//    sacar(valor)
//    contaDestino.deposita(valor)
  }

  /**
   * Em vez de implementar o autentica podemos utilizar o que já
   * foi implementado no Cliente com o retorno abaixo da função.
   */
  override fun autentica(senha: Int): Boolean {
    return titular.autentica(senha) // <- AQUI
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