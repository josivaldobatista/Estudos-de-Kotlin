package br.com.jfb.bytebank.test

import br.com.jfb.bytebank.models.*

fun testaObjects() {
  var fran = object : Autenticavel {
    val nome: String = "Fran"
    val cpf: String = "85296374111"
    val senha: Int = 123456

    override fun autentica(senha: Int) = this.senha == senha
  }

  val sistemaInterno = SistemaInterno()
  sistemaInterno.entra(fran, 123456)
  println("nome do CLiente Object: ${fran.nome}")

  var alex = Cliente("Alex Black", cpf = "74185296332", senha = 123456)
  var contaPoupanca = ContaPoupanca(titular = alex, numero = 8526)
  var contaCorrente = ContaCorrente(titular = alex, numero = 6542)

  println("Total contas: ${Conta.total}")
}