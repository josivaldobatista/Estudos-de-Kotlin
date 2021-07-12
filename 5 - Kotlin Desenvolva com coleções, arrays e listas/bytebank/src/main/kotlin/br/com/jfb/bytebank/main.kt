package br.com.jfb.bytebank

import br.com.jfb.bytebank.models.Livro
import br.com.jfb.bytebank.models.Prateleira
import br.com.jfb.bytebank.utils.imprimeComMarcadores
import br.com.jfb.bytebank.utils.listaDeLivros
import br.com.jfb.bytebank.utils.listaDeLivrosComNulo

fun main() {

  val prateleira = Prateleira(
    genero = "Literatura",
    livros = listaDeLivros
  )

  val porAutor = prateleira.organizarPorAutor()
  val porPublicacao = prateleira.organizarPorAnoPublicacao()

  porAutor.imprimeComMarcadores()
  porPublicacao.imprimeComMarcadores()

  /**
   * Posso usar o groupBy para agrupar uma lista por um atributo do meu objeto
   * */
//  listaDeLivros
//    .groupBy { it.editora ?: "Unknown Publisher"}
//    .forEach { (editora: String?, livros: List<Livro>) ->
//      println("$editora : ${livros.joinToString { it.titulo }}")
//    }

} // <- Fim do main()
























