package br.com.jfb.testes


fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima = fun(a: Int, b: Int): Int {
        return a + b
//        println("Minha função anonima...")
    }
    println(minhaFuncaoAnonima(10, 16))


    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0) {
            return salario + 50.0
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(5000.0))
}

fun testaFuncaoLambda() {
    //    val minhaFuncaoLambida: (Int, Int) -> Int = { a, b -> a + b }
    val minhaFuncaoLambida = { a: Int, b: Int -> a + b } // <- com inferencia de tipos
    //println("Executa como lambda...")

    println(minhaFuncaoLambida(10, 10))
    /**
     * No código abaixo devido que em uma função lambda retorna a ultima expressão
     * podemos usar o "@<nomeQualquer>" para poder indicar mais de um retorno.
     *
     * Temos um if que precisar ser verificado e retornado caso seja verdadeiro, então
     * adicionei uma LABEL chamada @lambda(mas pode ser qualquer nome) e onde quero que
     * tenha um retorno uso essa label nesse local.
     *
     * Tomar cuidado com o It pois caso tenha muitas funções e funções dentro de funções
     * seu código pode ficar confuso então use o apelido para nomear-la. No caso abaixo usei
     * o salario.
     * */

    /**
     * De modo geral segundo o estrutor do curso da alura, vamos usar mais
     * a expressão lambda e menos a função anonima, por causa que é mais conhecida.
     * */

    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->//<- apelido aqui salario
        if (salario > 1000.0) {
            return@lambda salario + 50.0
        }
        salario + 100.0
    }
    println(calculaBonificacao(1100.0))
}

fun testeTipoFuncaoClasse() {
    //    val minhaFuncaoClass: () -> Unit = Teste()
    val minhaFuncaoClass: (Int, Int) -> Int = Soma() // não preciso declarar pois o kotlin subentende
    println(minhaFuncaoClass(10, 10))
}

fun testeTipoFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
    /**
     * Todos os tipos de função têm uma parêntesis lista de tipos de parâmetros e um
     * tipo de retorno: (A, B) -> C denota um tipo que representa funções que recebem
     * dois argumentos de tipos Ae Be retornar um valor do tipo C.
     *
     * O tipo função sempre retorna alguma coisa
     * */
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}