package br.com.jfb.testes


fun testeSet2() {
    val assistirCursoAndroid: Set<String> = setOf("Bob", "Maria", "João", "Pedro", "José")
    val assistirCursoKotlin: Set<String> = setOf("Bob", "Marcos", "Francisco", "Pedro")

    val assistiramAmbos: Set<String> = assistirCursoAndroid + assistirCursoKotlin

    println(assistirCursoAndroid + assistirCursoKotlin) // Adição
    println("EXEMPLO UNION: ${assistirCursoKotlin union assistirCursoAndroid}")
    println(assistirCursoAndroid - assistirCursoKotlin) // Adição
    println("EXEMPLO SUBTRACT: ${assistirCursoKotlin subtract assistirCursoAndroid}")

    println(assistirCursoAndroid.intersect(assistirCursoKotlin)) // buscar os que estão nas duas listas

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Bob")
    println(assistiramList)
    println(assistiramList.toSet())
}

fun testeSet1() {
    val assistiramCursoAndroid: MutableSet<String> = mutableSetOf(
        "Alex Red", "Bob Brown", "Maria Green", "Mike Golden", "Luke Blue"
    )

    // val assistiramCursoKotlin: List<String> = listOf("Alex Red", "Bob Brown", "Mike Golden")
    val assistiramCursoKotlin: MutableSet<String> = mutableSetOf("Alex Red", "Bob Brown", "Mike Golden")

    //val assistiramAmbos: Set<String> = assistiramCursoAndroid + assistiramCursoKotlin

    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.add("Pedro Rosa")
    assistiramAmbos.add("Maria Green")

    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramAmbos)

    // Automagicamente ele ja excluiu os elementos que eram repetidos com o SET abaixo
    println(assistiramAmbos)
}

fun testeLista() {
    val assistiramCursoAndroid: List<String> = listOf(
        "Alex Red", "Bob Brown", "Maria Green", "Mike Golden", "Luke Blue"
    )
    val assistiramCursoKotlin: List<String> = listOf("Alex Red", "Bob Brown", "Mike Golden")

    val assistiramAmbos: List<String> = assistiramCursoAndroid + assistiramCursoKotlin

    // .distinct -> Para pegar os valores que não são repetidos
    println(assistiramAmbos.distinct())
}