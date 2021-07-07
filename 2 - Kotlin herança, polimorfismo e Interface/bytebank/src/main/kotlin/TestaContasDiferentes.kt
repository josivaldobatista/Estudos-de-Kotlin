fun testaContasDiferentes() {
  val contaCorrente = ContaCorrente(
    titular = "Alex",
    numero = 7896
  )

  val contaPoupanca = ContaPoupanca(
    titular = "Fran",
    numero = 3216
  )

  contaCorrente.deposita(1000.00)
  contaPoupanca.deposita(1000.00)

  println("Saldo conta corrente: ${contaCorrente.saldo}")
  println("Saldo conta poupança: ${contaPoupanca.saldo}")

  contaCorrente.sacar(100.00)
  contaPoupanca.sacar(100.00)

  println("Saldo conta corrente após saque: ${contaCorrente.saldo}")
  println("Saldo conta poupança após saque: ${contaPoupanca.saldo}")

  contaCorrente.transferencia(contaPoupanca, 100.00)

  println("Saldo conta corrente após transferência corrente: ${contaCorrente.saldo}")
  println("Saldo conta poupança após transferência corrente: ${contaPoupanca.saldo}")

  contaPoupanca.transferencia(contaCorrente, 200.00)

  println("Saldo conta corrente após transferência poupança: ${contaCorrente.saldo}")
  println("Saldo conta poupança após transferência poupança: ${contaPoupanca.saldo}")
}