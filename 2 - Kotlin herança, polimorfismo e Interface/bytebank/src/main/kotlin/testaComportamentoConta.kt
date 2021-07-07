
fun testaComportamentoConta() {
  val contaValdo = ContaCorrente(titular = "Valdo Batista", numero = 7536)
  contaValdo.deposita(1000.00)
  println(contaValdo.titular)
  println(contaValdo.numero)
  println(contaValdo.saldo)

  val contaMaria = ContaPoupanca(numero = 9516, titular = "Maria Banana")
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