package models

import models.Funcionario

class CalculadoraBonificacao {

  var total: Double = 0.0
    private set

  fun registra(funcionario: Funcionario) {
    println("Nome: ${funcionario.nome}")
    this.total =+ funcionario.bonificacao
  }

//  fun registra(gerente: models.Gerente) {
//    this.total =+ gerente.bonificacao
//  }
//
//  fun registra(diretor: models.Diretor) {
//    this.total =+ diretor.bonificacao
//  }

}