
abstract class Conta(
  var titular: String,
  val numero: Int
) {

  var saldo = 0.0
    protected set

  fun deposita(valorDeposito: Double) {
    if (valorDeposito > 0) {
      this.saldo += valorDeposito
      println("Depositando na conta do(a) $titular")
    }
  }

  abstract fun sacar(valorSacar: Double)

  fun transferencia(contaDestino: Conta, valor: Double): Boolean {
    if (saldo >= valor) {
      sacar(valor)
      contaDestino.deposita(valor)
      return true
    }
    return false
  }

}