import br.com.jfb.bytebank.models.Cliente
import br.com.jfb.bytebank.models.ContaCorrente
import br.com.jfb.bytebank.models.ContaPoupanca

fun testaCopiasEReferencias() {

  val numeroX = 10
  var numeroY = numeroX
  numeroY++

  println("numeroX $numeroX")
  println("numeroY $numeroY")

  val contaJoao = ContaCorrente(Cliente(
    nome = "João",
    cpf = "22255588866",
    senha = 123456),
    1234)
  contaJoao.titular.nome = "João"

  var contaMaria = ContaPoupanca(Cliente(
    nome = "Maria",
    cpf = "12345678998",
    senha = 123456),
    1654)
  contaMaria.titular.nome = "Maria"
  contaJoao.titular.nome = "João"

  println("titular conta joao: ${contaJoao.titular}")
  println("titular conta maria: ${contaMaria.titular}")

  println(contaJoao)
  println(contaMaria)
}