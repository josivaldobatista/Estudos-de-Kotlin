import br.com.jfb.bytebank.models.Endereco
import java.lang.IllegalStateException

fun main() {

  val a = "Kotlin"
  val b: String? = null
  println("Retorna o tamanho de B se não for nulo: ${b?.length}")
  println("Retorna o tamanho de A se não for nulo: ${a?.length}") // Unnecessary safe call

  println("*************************")


  // Operador Elvis: "se b não for null, use-a, caso contrário, use algum valor não nulo. Veja abaixo"
  val l = b?.length ?: -1
  println("Usando o Elvis operator: $l")

  // ? = Nullable
  // As variáveis que não te interrogação

  //SAFE CALL
  //O "?" é uma forma enxuta de verificar se é nulo sem usar o "IF"
  var enderecoNullo: Endereco? = Endereco(logradouro = "Rua vergueiro", complemento = "Casa 1") // = null
  println(enderecoNullo?.logradouro)
  val logradouroNovo: String? = enderecoNullo?.logradouro
  println(enderecoNullo?.logradouro?.length?.toByte()) // para cada chamada preciso o "?"

// TESTE
//  val enderecoNaoNull: Endereco = enderecoNullo!!
//  enderecoNaoNull.logradouro

  // LET
  enderecoNullo?.let { // Sem apelido
    println(it?.logradouro)
    // Podemos lançar uma exception com o operador Elvis. Veja abaixo:
    val tamanhoComplemento: Int = it.complemento?.length ?: throw IllegalStateException(
      "Complemento não pode ser vazio"
    )
    println("Tamanho complemento $tamanhoComplemento")
  }
  // enderecoNullo = null <- vai funcionar mesmo assim
  enderecoNullo?.let { endereco: Endereco -> // com apelido
    println(endereco.logradouro.length) // Aqui não preciso usar a Safe call para todos os menbros
    // por causa do "?" depois do "enderecoNulo?"
  }
  //Safe casts
  teste("d")

}

// Safe casts
fun teste(valor: Any) {

  /***
   * No Safe Casts, eu indico que o valor pode ser nulo e vai tentar converter,
   * e se não consegui o número que estamos vendo ali vai receber nulo
   */
  val numero: Int? = valor as? Int
  println(numero) // Alternativa para fazer um cast seguro
}










