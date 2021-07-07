fun testaFuncionarios() {
  println()
  println("Informações do Funcionario")
  val alex = Analista(
    "Alex Batista",
    "333.555.789.65",
    5000.0
  )

  println("Nome: ${alex.nome}")
  println("CPF: ${alex.cpf}")
  println("Salário: ${alex.salario}")
  println("Bonificação: ${alex.bonificacao}")

  val fran = Gerente(
    nome = "Fran",
    cpf = "222.555.666.85",
    salario = 10000.00,
    senha = 123456
  )

  println()
  println("Informações de Gerente")
  println("Nome: ${fran.nome}")
  println("CPF: ${fran.cpf}")
  println("Salário: ${fran.salario}")
  println("Bonificação: ${fran.bonificacao}")

  if (fran.autentica(123456)) {
    println("Autenticou com sucesso!")
  } else {
    println("Falha na autenticação")
  }

  println()
  println("Informações de Diretor")
  val gui = Diretor(
    nome = "Guilherme",
    cpf = "123.456.789.32",
    salario = 15000.00,
    senha = 123456,
    plr = 5000.0
  )

  val maria = Analista(
    "Maria White",
    "159.753.852.36",
    4500.00
  )

  println("Nome: ${gui.nome}")
  println("CPF: ${gui.cpf}")
  println("Salário: ${gui.salario}")
  println("Bonificação: ${gui.bonificacao}")
  println("PLR: ${gui.plr}")

  if (fran.autentica(123456)) {
    println("Autenticou com sucesso!")
  } else {
    println("Falha na autenticação")
  }

  val calculadora = CalculadoraBonificacao()
  calculadora.registra(alex)
  calculadora.registra(fran)
  calculadora.registra(gui)
  calculadora.registra(maria)

  println()
  println("Total de bonificação: ${calculadora.total}")
}