package br.com.jfb.testes

fun testeMap3() {
    val pedidos = mutableMapOf<Int, Double>(
        Pair(1, 20.00),
        Pair(2, 34.00),
        3 to 50.00,
        4 to 800.00,
        5 to 800.00
    )

    //PLUS AND MINUS OPERATORS
    println(pedidos + Pair(7, 35.0))
    println(pedidos + mapOf(8 to 200.0, 9 to 753.0))

    println(pedidos - 1)// < valor que queremos tirar, podemos usar para indicar uma lista de valores
    //   para tirar

    pedidos.putAll(setOf(10 to 654.0, 1 to 357.0))// vai atualizar se a chave já existe
    pedidos += (setOf(12 to 654.0, 13 to 357.0)) // mesmo comportamento do putAll
    println(pedidos)

    // O remove vai retirar o primeiro que encontrar, mas se tiver repetido
    // vai manter
    pedidos.values.remove(50.0)
    println(pedidos)

    pedidos.values.remove(800.0)
    println(pedidos)

    pedidos -= 12
    println(pedidos)
}
fun testeMap2() {
    val pedidos = mutableMapOf<Int, Double>(
        Pair(1, 20.00),
        Pair(2, 34.00),
        3 to 50.00,
        4 to 800.00
    )

    /**
     * Usando o getValue() caso o valor exista mas não tenha valor retorna um null
     * mas se não estiver nem registrado lançará uma exception "NoSuchElementException"
     * */
    val valorPedido = pedidos.getValue(4)
    println(valorPedido)

    /**
     * Temos no Map uma função chamada getOrElse() que tem um comportamento bem parecido
     * com o get() mas vai fazer um retorno a parti de uma expressão lambda
     * */
    println(pedidos.getOrElse(0, {
        "Não tem o pedido"
    }))

    // Retorna um valor padrão caso não exista a chave informada
    println("getOrDefault(): " + pedidos.getOrDefault(0, -1.0))

    // Mostra todas as chaves ou valores
    println(pedidos.keys)
    println(pedidos.values)

    println("PEDIDOS E VALORES INDICE")
    for (numero in pedidos.keys) {
        println("Pedido $numero: Valor ${pedidos[numero]}")
    }

    //Filtrando com o MAP
    val pedidosFiltrados = pedidos.filter { (numero, valor) -> // preciso sempre passar entre parenteses
        numero % 2 == 0 && valor > 70.0
    }

    println(pedidosFiltrados)

    // Filtro por valor
    pedidos.filterValues { valor ->
        valor > 60.0
    }

    // Filtro por keys
    pedidos.filterKeys { pedido ->
        pedido > 1
    }
}
fun testeMap1() {
    val pedidos = mutableMapOf<Int, Double>(
        Pair(1, 20.00),
        Pair(2, 34.00),
        3 to 50.00
    )

    //Inserindo um novo elemento
    pedidos[4] = 70.00
    println(pedidos[4])

    //Inserção dom o PUT
    pedidos.put(5, 90.00)
    println(pedidos)

    // Atualizando valor do MAP é feita também com o PUT
    pedidos[1] = 100.00
    println(pedidos)

    // Mas se em nenhum momento a atualização não é o que quero fazer então
    //uso o "putIfAbsent"

    pedidos.putIfAbsent(6, 200.00) //<- Se já tiver um pedido 6 não vai atualizar usando o "putIfAbsent"
    println(pedidos)

    pedidos.putIfAbsent(6, 1000.00) //<- Não vai atualizar
    println(pedidos)

    // Para remover
    pedidos.remove(6)
    println(pedidos)

    /**
     * Temos uma sobrecarga no remove que fará a remoção apenas se o valor da chave informado
     * for igual, caso contrario não frá nada
     * */
    pedidos.remove(4, 5000.0)//<- perceba que a chave 4 ficara intacta
    println(pedidos)
}
fun testeIntroducaoAoMap() {
    /**
     * O map é usado com um par de chave valor como está no exemplo abaixo
     * note que podemos definir usando o Pair(K,T) ou usando apenas o K to T (da no mesmo)
     * */
    // mapOf<Int, Double>(Pair(1, 20.00), Pair(2, 34.00), 3 to 50.00)
    val pedidos = mapOf<Int, Double>(Pair(1, 20.00), Pair(2, 34.00), 3 to 50.00)
    println(pedidos)

    /**
     * Obs.: Para usar o efix (K to T) como mostrado acima devemos ter em mente que possui
     * perda de performace então usar com cuidado.
     * */
    // Pegar um unico elemento
    val pedido1 = pedidos[0]
    println(pedido1)

    /**
     * Como o valor pode ser nulo devemos fazer as trataivas usando o nullsafe
     * visto nas outras aulas
     * */
    val pedido2 = pedidos[1]
    pedido2?.let {
        println("PEDIDO: $it")
    }

    println()
    println("ID E VALOR DO PEDIDO")
    for (pedido: Map.Entry<Int, Double> in pedidos) {
        println("Numero do pedido: ${pedido.key}")
        println("Valor do pedido: ${pedido.value}")
    }
}