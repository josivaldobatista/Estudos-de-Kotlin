import br.com.jfb.bytebank.models.Cliente
import br.com.jfb.bytebank.models.ContaCorrente
import br.com.jfb.bytebank.models.ContaPoupanca
import br.com.jfb.bytebank.models.Endereco

fun testaContasDiferentes() {

  val alex = Cliente(
    nome = "Alex",
    cpf = "85274196322",
    senha = 123456,
    endereco = Endereco(
      logradouro = "Rua Vergueiro"
    )
    )
  val contaCorrente = ContaCorrente(
    titular = alex,
    numero = 7896
  )

  val fran = Cliente(
    nome = "Fran",
    cpf = "32165498745",
    senha = 123456)
  val contaPoupanca = ContaPoupanca(
    titular = fran,
    numero = 3216
  )

  println("titular: ")
  println("Nome do titular: ${contaCorrente.titular.nome}")
  println("cpf do titular: ${contaCorrente.titular.cpf}")
  println("Endereco: ${contaCorrente.titular.endereco.logradouro}")

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