package br.com.jfb.testes


fun testaCopia() {
    val banco = BancoDeNomes()
    val nomeSalvos: Collection<String> = banco.nomes
    // banco.nomes.add("Bob Brown") <- não posso adicionar nomes depois do private
    //nomeSalvos.add("Siqueira")
    banco.salva("Maria Green")
    println("NOMESALVO: $nomeSalvos")
    println("BANCODENOMES: ${BancoDeNomes().nomes}")
}

/**
 * Precisamos tomar alguns coidados com coleções que são mutaveis
 * como pro exemplo restringir o acesso com o modificador de acesso "private"
 * */
class BancoDeNomes {
    val nomes: Collection<String> get() = dados.toList()

    fun salva(nome: String) {
        dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>() // <- private para restringir o acesso.
    }
}

fun testaColecao() {
    /**
     * Usar o List, Collection ou o Iterable vai compilar e rodar o código
     * sem problema pois eles compartilham dos mesmos comportamentos
     * (usando o List ou Set)
     * */
    // val nomes:List<String> = listOf(
    // val nomes:Collection<String> = listOf(
    val nomes: Collection<String> = mutableListOf(
        "Valdo Batista",
        "Maria White",
        "Bob Bronw",
        "Mike Green"
    )

    for (nome in nomes) {
        println(nome)
    }
    println("NOMES: $nomes")
    if (nomes.contains("Valdo Batista")) {
        println("Sim, esse nome está na lista")
    } else {
        println("Não, esse nome não está na lista")
    }
}