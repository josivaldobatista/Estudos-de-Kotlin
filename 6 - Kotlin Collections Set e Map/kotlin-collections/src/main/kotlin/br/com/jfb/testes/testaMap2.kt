package br.com.jfb.testes

import br.com.jfb.models.Pedido


fun testeMapEOutrasFeatures() {
    // Collection transformation operations

    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 300.0),
        Pedido(3, 400.0),
        Pedido(4, 6300.0),
        Pedido(5, 500.0)
    )

    println(pedidos)
    val pedidosMapeados = pedidos.associate { pedido: Pedido ->
        Pair(pedido.id, pedido)
        // Pair(pedido.id to pedido) //<- podemos usar o infix
    }

    // USANDO O ASSOCIATEBY  Fica mais reduzido que o acima
    val pedidosMapeados2 = pedidos.associateBy { pedido ->
        pedido.id
        // Pair(pedido.id to pedido) //<- podemos usar o infix
    }

    println(pedidosMapeados)
    println(pedidosMapeados[1])

    // ASSOCIATEWITH
    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }

    /**
     * Para cada elemento vai associar com alguma regra de negorcio que tenhamos
     * implemenado
     * */
    println(pedidosFreteGratis)

    // vai retorna false
//    println(pedidosFreteGratis[Pedido(id = 1, valor = 20.0)])
//
//    val mapa = pedidos.associateBy { pedido -> pedido.valor > 50 }
//    println(mapa)

    /**
     * Vai agrupar os pedidos baseado no que for informado na regra de negocio
     * Criando assim uma nova coleção com o resultado
     * */
    val peidosFreteGratisAgrupados: Map<Boolean, List<Pedido>> = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50
    }

    println(peidosFreteGratisAgrupados)

    //pedidos com frete gratis
    println(peidosFreteGratisAgrupados[true])

    val nomesQualquer = listOf("Valdo", "Fran", "Alex", "Gui", "Aana", "Maria", "Bob", "Marcos")

    val agenda: Map<Char, List<String>> = nomesQualquer.groupBy { nome ->
        nome.first()
    }

    println(agenda)
    println(agenda['A'])
}
fun exemploDocumentacao1() {
    // COLECTIONS TRANSFORMATION
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })
}
