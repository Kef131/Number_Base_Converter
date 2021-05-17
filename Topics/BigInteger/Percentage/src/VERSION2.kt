import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val sum = a + b
    val unity  = BigDecimal("100").divide(BigDecimal(sum), 50, RoundingMode.UP)
    var resultA = (unity * BigDecimal(a))
    var resultB = (unity * BigDecimal(b))
    if (resultA < BigDecimal.ONE) {
        resultA = BigDecimal.ZERO
        resultB = BigDecimal("99")
    } else if (resultB < BigDecimal.ONE) {
        resultA = BigDecimal("99")
        resultB = BigDecimal.ZERO
    }
    println("${resultA.toInt()}% ${resultB.toInt()}%")
}