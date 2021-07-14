package br.com.jfb.testes

import br.com.jfb.models.Autenticavel
import br.com.jfb.models.SistemaInterno

fun testaHOF() {
    soma(1, 5, resultado = {
        println(it)
    })

    soma(1, 5, resultado = (::println))

    val autenticavel = object : Autenticavel {
        val senha = 123456
        override fun autentica(senha: Int) = this.senha == senha
    }

    SistemaInterno().entra(autenticavel, 123456, autenticado = {
        println("Realizar pagamento")
    })
}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("Soma sendo efetuada...")
    resultado(a + b)
}
