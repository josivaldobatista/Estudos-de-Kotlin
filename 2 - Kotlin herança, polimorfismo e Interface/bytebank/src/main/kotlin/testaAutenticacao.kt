fun testaAutenticacao() {
  val gerente = Gerente(
    nome = "Alex",
    cpf = "78965412325",
    salario = 7500.00,
    senha = 123456
  )

  val diretora = Diretor(
    nome = "Fran",
    cpf = "32165498778",
    salario = 10000.00,
    senha = 123456,
    plr = 2000.00
  )

  val cliente = Cliente(
    nome = "Bob Brown",
    cpf = "58269347152",
    senha = 123456
  )

  val sistemaInterno = SistemaInterno()
  sistemaInterno.entra(gerente, 123456)
  sistemaInterno.entra(diretora, 123456)
  sistemaInterno.entra(cliente, 123456)
}