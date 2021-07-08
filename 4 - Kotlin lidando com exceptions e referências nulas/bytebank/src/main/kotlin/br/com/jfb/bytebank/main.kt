import br.com.jfb.bytebank.models.Endereco
import br.com.jfb.bytebank.test.testaAny
import java.lang.ArithmeticException
import java.lang.ClassCastException
import java.lang.NumberFormatException

fun main() {
  println("início main")

  val entrada: String = "1.0"
  val valorRecebido: Double? = try {
    entrada.toDouble()
  } catch (e: NumberFormatException) {
    println("Erro na conversão")
    e.printStackTrace()
    null
  }
  val valorComTaxa: Double = if (valorRecebido != null) { // ?
    valorRecebido + 0.1
  } else {
    // Podemos colocar um valor padrão em vez de null como está abaixo
      // Veja o exemplo acima
    0.0
    //  Em vez null
  }

  if (valorComTaxa != null) {
    println("Valor recebido: $valorComTaxa")
  } else {
    println("Valor invalido: $valorComTaxa")
  }
  try {
    10 / 0
  } catch (e: ArithmeticException) {
    println("A ERRO de ArithmeticException.class")
  }
  funcao1()
  println("fim main")
}

fun funcao1() {
  println("início funcao1")
  try {
    funcao2()
  } catch (e: ClassCastException) {
    println("Mensagem exception: ${e.message}")
    println("StackTrace: ${e.stackTrace}")
    println("ERRO de ClassCastException.class")
    println("Causa: ${e.cause}")

    // A PrintStackTrace imprime as três informações acima
    println("PrintStackTrace: ${e.printStackTrace()}")
  }
  println("fim funcao1")
}

fun funcao2() {
  println("início funcao2")
  for (i in 1..5) {
    println(i)
    val endereco = Any()
    endereco as Endereco
  }
  println("fim funcao2")
}









