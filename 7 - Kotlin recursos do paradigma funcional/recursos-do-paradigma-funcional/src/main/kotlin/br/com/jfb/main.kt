package br.com.jfb

import br.com.jfb.models.Cliente
import br.com.jfb.models.ContaPoupanca
import br.com.jfb.models.Endereco

fun main() {
    testaRun()
    testaWith()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("Taxa mensal: $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Bob Brown", cpf = "98765432152", senha = 123456), 9514)
    contaPoupanca.run {
        deposita(1000.0)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println("Rendimento mensal: $rendimentoMensal")
    }

    run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }.let { rendimentoAnual ->
        println("Rendimento anual: $rendimentoAnual")
    }
}
fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua Verqueiro"
        bairro = "Vila Mariana"
        numero = 8524
        cidade = "São Paulo"
        estado = "SP"
        cep = "52987350"
        complemento = "Casa 1"
        completo()
    }.let(::println)
}


