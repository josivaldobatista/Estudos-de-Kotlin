package br.com.jfb.bytebank.models

class CalculadoraBonificacao {

  var total: Double = 0.0
    private set

  fun registra(funcionario: Funcionario) {
      println("Nome: ${funcionario.nome}")
      this.total = +funcionario.bonificacao
    }

  }

//  fun registra(gerente: br.com.jfb.bytebank.models.Gerente) {
//    this.total =+ gerente.bonificacao
//  }
//
//  fun registra(diretor: br.com.jfb.bytebank.models.Diretor) {
//    this.total =+ diretor.bonificacao
//  }

