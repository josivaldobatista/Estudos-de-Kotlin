package br.com.jfb.testes

import br.com.jfb.models.Endereco

fun testaFuncaoDeEscopo() {
    //    val endereco = Endereco(logradouro = "Rua Vergueiro", numero = 3214)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    val enderecoEmMaiusculo = Endereco(logradouro = "Rua Vergueiro", numero = 3214)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        }.let(::println)

    val enderecosComComplementos = listOf(
        Endereco(complemento = "Casa 1"),
        Endereco(),
        Endereco(complemento = "Apartamento")
    ).filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(::println)
}