package models

abstract class Funcionario(
  val nome: String,
  val cpf: String,
  val salario: Double,
) {

  //FUNÇÃO ENXUTA E FAZ A MESMA COISA DAS DECLARADAS ABAIXO
  abstract val bonificacao: Double

// CONVERTENDO FUNÇÃO EM PROPERTIES
//  open val bonificacao: Double
//    get() {
//      return salario * 0.1
//    }

// FUNÇÃO NORMAL
//  open fun bonificacao(): Double {
//    return salario * 0.1
//  }

}
