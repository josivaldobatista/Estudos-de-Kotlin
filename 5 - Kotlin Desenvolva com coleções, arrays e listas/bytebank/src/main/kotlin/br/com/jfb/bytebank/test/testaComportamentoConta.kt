import br.com.jfb.bytebank.exceptions.FalhaAutenticacaoException
import br.com.jfb.bytebank.exceptions.SaldoInsuficienteException
import br.com.jfb.bytebank.models.Cliente
import br.com.jfb.bytebank.models.ContaCorrente
import br.com.jfb.bytebank.models.ContaPoupanca

fun testaComportamentoConta() {

  val valdo = Cliente(nome = "Valdo Batista", cpf = "987654123355", senha = 123456)

  val contaValdo = ContaCorrente(titular = valdo, numero = 7536)
  contaValdo.deposita(1000.00)
  println(contaValdo.titular)
  println(contaValdo.numero)
  println(contaValdo.saldo)

  val maria = Cliente(nome = "Maria White", cpf = "56489723144", senha = 123456)
  val contaMaria = ContaPoupanca(numero = 9516, titular = maria)
  contaMaria.deposita(6000.00)
  println(contaMaria.titular)
  println(contaMaria.numero)
  println(contaMaria.saldo)

  println("************************")

//    contaValdo.deposita(50.0)
//    println(contaValdo.saldo)

  println("************************")

  /*println("Sacando da conta do $titular")
  contaValdo.sacar(1000.0)
  println("Saldo da conta: ${contaValdo.saldo}")*/

  println("************ TRANSFERÊNCIA ************")
  println("Tranferindo da conta da Maria para conta do Valdo")

  try {
    contaMaria.transferencia(contaValdo, 5000.0, 123456)
    println("Transferência realizada com sucesso")
  } catch (e: FalhaAutenticacaoException) {
    println("Falha na transferência")
    println("Falha na autenticação")
    e.printStackTrace()
  } catch (e: SaldoInsuficienteException) {
    println("Erro na Transferência")
    println("Saldo insuficiente")
    e.printStackTrace()
  } catch (e: Exception) {
    println("Erro desconhecido")
    e.printStackTrace()
  }

  println("Saldo do Valdo: ${contaValdo.saldo}")
  println("Saldo do Maria: ${contaMaria.saldo}")
}