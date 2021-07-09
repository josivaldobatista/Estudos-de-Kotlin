package br.com.jfb.bytebank.exceptions

class SaldoInsuficienteException(
  mensagem: String = "Saldo insuficiente"
) : Exception(mensagem)
