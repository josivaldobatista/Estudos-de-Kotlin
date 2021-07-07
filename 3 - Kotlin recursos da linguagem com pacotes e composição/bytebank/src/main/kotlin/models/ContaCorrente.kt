package models

import models.Conta

class ContaCorrente(
  titular: String,
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