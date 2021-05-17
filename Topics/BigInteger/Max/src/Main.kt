import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val max = (a + b + (a - b).abs()).divide(BigInteger.TWO)
    print(max)
}