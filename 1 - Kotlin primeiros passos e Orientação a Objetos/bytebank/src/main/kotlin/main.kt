fun main() {
  println("Bem-vindo ao BYTEBANK")
  println("************************")
  val contaValdo = Conta(titular = "Valdo Batista", numero = 7536)
  contaValdo.deposita(1000.00)
  println(contaValdo.titular)
  println(contaValdo.numero)
  println(contaValdo.saldo)

  val contaMaria = Conta(numero = 9516, titular = "Maria Banana")
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

  if (contaMaria.transferencia(contaValdo, 1000.0)) {
    println("Transferência realizada com sucesso")
  } else {
    println("Erro na Transferência")
  }

  println("Saldo do Valdo: ${contaValdo.saldo}")
  println("Saldo do Maria: ${contaMaria.saldo}")

}

class Conta(
  val titular: String,
  val numero: Int
) {

  var saldo = 0.0
    private set

  fun deposita(valorDeposito: Double) {
    if (valorDeposito > 0) {
      this.saldo += valorDeposito
      println("Depositando na conta do(a) $titular")
    }
  }

  private fun sacar(valorSacar: Double) {
    if (this.saldo <= valorSacar) {
      println("Você não tem saldo suficiente para esta operação")
    } else {
      saldo -= valorSacar
    }
  }

  fun transferencia(contaDestino: Conta, valor: Double): Boolean {
    if (saldo >= valor) {
      sacar(valor)
      contaDestino.deposita(valor)
      return true
    }
    return false
  }

}


