package br.com.jfb.bytebank.utils

import br.com.jfb.bytebank.models.Livro

/**
 * Para usar essa função em uma lista que pode ter nulos, preciso colocar
 * a interrogação depois do livro dentro da lista, porém na hora de chamar o titulo e autor
 * posso tomar um NullPointeException, como chamar o titulo e autor em um elemento nulo?
 *
 * Para resolver isso devo usar a safeCall, assim o kotlin só ira chamar o titulo e autor se o objeto
 * não for nulo.
 * */
fun List<Livro?>.imprimeComMarcadores() {
  val textFormatado = this
    .filterNotNull() //<- Evita que a lista de titulo e autor seja mostrada elementos nulos
    .joinToString(separator = "\n") {
      " - LIVRO: ${it.titulo} DE: ${it.autor}" // <- e posso tirar o safe call
    }
  println("####  LISTA DE LIVROS ####\n$textFormatado")
}

/**
 * Posso usar o groupBy para agrupar uma lista por um atributo do meu objeto
 * */

