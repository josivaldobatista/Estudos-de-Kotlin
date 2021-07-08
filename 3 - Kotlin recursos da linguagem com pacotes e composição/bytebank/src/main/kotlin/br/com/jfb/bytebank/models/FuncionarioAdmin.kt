package br.com.jfb.bytebank.models

abstract class FuncionarioAdmin(
  nome: String,
  cpf: String,
  salario: Double,
  protected val senha: Int
) : Funcionario(
  nome = nome,
  cpf = cpf,
  salario = salario
), Autenticavel {

  //FUNÇÃO ENXUTA E FAZ A MESMA COISA DAS DECLARADAS ABAIXO

  override fun autentica(senha: Int): Boolean {
    if (this.senha == senha) {
      return true
    }
    return false
  }

}
