import java.math.BigInteger
import kotlin.math.pow

fun main() {
    val exabyte = BigInteger.valueOf(2)
    println(readLine()!!.toBigInteger() * exabyte.pow(63))
}