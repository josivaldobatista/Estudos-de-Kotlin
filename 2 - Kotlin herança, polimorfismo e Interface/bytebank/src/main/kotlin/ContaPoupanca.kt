class ContaPoupanca(
  titular: String,
  numero: Int
) : Conta(
  titular = titular,
  numero = numero
) {
  override fun sacar(valorSacar: Double) {
    if (this.saldo >= valorSacar) {
      this.saldo -= valorSacar
    }
  }
}
