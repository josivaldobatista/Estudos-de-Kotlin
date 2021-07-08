import br.com.jfb.bytebank.models.Endereco

fun main() {

  val endereco = Endereco(logradouro = "Rua das Marmotas", complemento = "Alura")
  val enderecoNovo = Endereco(bairro = "Vila Mariana", numero = 8524)
  println(endereco.equals(endereco))

  println(endereco.hashCode())
  println(enderecoNovo.hashCode())

  println(endereco.toString())
  println(enderecoNovo.toString())
}

fun imprime(valor: Any): Any {
  println(valor)
  return valor
}









