package br.com.jfb.bytebank.models

data class Prateleira(
  /**
   * Podemos ter problemas na hora de usar o MutableList pois ao charmar
   * duas listas que foram por exemplo, organizadas diferentes podem ter
   * inconsistencias já que o o Mutablelist altera a lista.
   *
   * Para resolver esse priblema podemos usar o List em vez do MutableList
   * ao fazer isso devemos tambem alterar a função "sortBy" para "sortedBy"
   * */

  val genero: String,
  val livros: List<Livro>
) {
  fun organizarPorAutor(): List<Livro> {
    return livros.sortedBy { it.autor }
  }

  /**
   * Tando a maneira que esta acima na função organizaPorAutor quanto
   * a que estão abaixo, fazem praticamente a mesma coisa mas, achei deixar
   * diferentes para ter um exemplo.
   * */
  fun organizarPorAnoPublicacao(): List<Livro> {
    val organizaPorAnoPub = livros.sortedBy { it.anoPublicacao }
    return organizaPorAnoPub
  }

  /**
   * Usando o List estou apontando para objetos diferentes
   * */
}