import br.com.jfb.bytebank.models.Endereco
import br.com.jfb.bytebank.test.testaAny
import java.lang.ArithmeticException
import java.lang.ClassCastException

fun main() {
  println("início main")
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









