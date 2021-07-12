package br.com.jfb.bytebank.test.arrays

import br.com.jfb.bytebank.models.Livro
import br.com.jfb.bytebank.utils.imprimeComMarcadores
import br.com.jfb.bytebank.utils.listaDeLivros

fun trabalhandoComListas() {
  val livro1 = Livro(
    titulo = "Grande Sertão: Veredas",
    autor = "João Guimarães Rosa",
    anoPublicacao = 1956
  )

  val livro2 = Livro(
    titulo = "Minha vida de Menina",
    autor = "Helena Morley",
    anoPublicacao = 1942,
    editora = "ABC"
  )

  val livro3 = Livro(
    titulo = "Memórias Póstumas de Brás Cuba",
    autor = "Machado de Assis",
    anoPublicacao = 1881
  )

  val livro4 = Livro(
    titulo = "Iracema",
    autor = "José de Alencar",
    anoPublicacao = 1865,
    editora = "JFB"
  )

  // Listas mutaveis
  val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

  /**
   * Com o MutableList podemos informa um genercs que no caso acima é do tipo Livro
   * e ter acesso a diversos métodos como o "add" mostrado abaixo:
   * */
  livros.add(// <- espera um tipo passado entre <>
    Livro(
      titulo = "Sagrana",
      autor = "João Guimarães Rosa",
      anoPublicacao = 1943
    )
  )
  livros.add(// <- espera um tipo passado entre <>
    Livro(
      titulo = "ABC",
      autor = "Josivaldo Batista",
      anoPublicacao = 2021,
      editora = "JFB"
    )
  )
  println(livros)

  livros.remove(livro1)
  println(livros)

  println()
  println("---------------------------------------------")

  /**
   * Vamos criar uma função para melhorar a visualização dos livros
   * */

  livros.imprimeComMarcadores()

  /**
   * Para realizar a ordenação de livros podemos usar o método "sorted" porém
   * a classe livro precisa de um parâmetro para realizar essa ordenação. Um outro ponto
   * é que, a classe livro precisar extender de "comparable" e é lá que vamos definir como
   * ou qual o parâmetro que realizaremos a ordenação.
   * */
  val ordenadoAnoPublicacao: List<Livro> = livros.sorted()
  //  println("Ordenado por ano de publicação: $ordenadoAnoPublicacao")

  ordenadoAnoPublicacao.imprimeComMarcadores()

  /**
   * Mas em alguns caso podemos querer ordernar por nome, ou algum outro critérios
   * além do anoPublicação mostrado acima usando o comparable na classe livro e,
   * para isso temos um método das listas chamado sortBy
   * */

  val ordenadoPorLivros = livros.sortBy { it.titulo }
  ordenadoAnoPublicacao.imprimeComMarcadores()

  livros.sortedBy { it.autor }.imprimeComMarcadores()

  /**
   * Para filtrar por um atributo
   * */
  println(" #### FILTRANDO UM LIVRO ####")
  val filterLivro = listaDeLivros
    .filter { it.autor == "George Orwell" }
    .sortedByDescending { it.anoPublicacao }
    .imprimeComMarcadores()

  // Filtrando apenas por uma letra ou primeiro nome
  println(" #### FILTRANDO UM LIVRO COMEÇANDO POR ####")
  val filterLivroStartWith = listaDeLivros
    .filter { it.autor.startsWith("George") }
    .sortedByDescending { it.anoPublicacao }
    .imprimeComMarcadores()

  println(" #### PEGANDO APENAS OS TITULOS ####")
  val titulos: List<String> = listaDeLivros
    .filter { it.autor.startsWith("George") }
    .sortedByDescending { it.anoPublicacao }
    .map { it.titulo }

  println(titulos)
}
