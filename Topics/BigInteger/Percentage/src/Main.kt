import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val sum = a + b
    val unity = BigDecimal("100").divide(BigDecimal(sum), 50, RoundingMode.UP)
    println("${(unity * BigDecimal(a)).toInt()}% ${(unity * BigDecimal(b)).toInt()}%")
}
