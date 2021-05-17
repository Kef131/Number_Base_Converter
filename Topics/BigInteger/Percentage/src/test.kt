import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

fun main(){
    var maxInt = Int.MAX_VALUE
    println("maxInt $maxInt ${maxInt::class.qualifiedName}")
    var bigInt0 = BigInteger.ZERO
    var bigInt1 = BigInteger.ONE
    var maxLong = Long.MAX_VALUE
    println("maxLong $maxLong ${maxLong::class.qualifiedName}")

    var maxIntPlus1 = maxInt.toBigInteger() + bigInt1
    println("maxIntPlus1 $maxIntPlus1 ${maxIntPlus1::class.qualifiedName}")

    var maxLongPlus1 = maxLong.toBigInteger() + BigInteger.ONE
    var maxLongPlus10 = maxInt.toBigInteger() + BigInteger.TEN
    println("maxLongPlus1 $maxLongPlus1 ${maxLongPlus1::class.qualifiedName}")

    println("-maxLongPlus1${-maxLongPlus1} ${maxLongPlus1::class.qualifiedName}")
    println("maxLongPlus10 / maxLongPlus1")
    println("DIVIDEANDREMINDER: ${maxLongPlus10.divideAndRemainder(maxLongPlus1).first()}")
    println("divide instead and pass the desired scale:: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 2, RoundingMode.HALF_UP)}")
    println("to double value: ${maxLongPlus10.toDouble() / maxLongPlus1.toDouble()}")
    println("using BigDecimal COMPLETE: ${maxLongPlus10.toBigDecimal().divide(maxLongPlus1.toBigDecimal())}")
    println("using BigDecimal, already defined precision CONTROLED 3 - HALF_DOWN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.HALF_DOWN)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - HALF_EVEN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.HALF_EVEN)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - HALF_UP: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.HALF_UP)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - DOWN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.DOWN)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - CEILING: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.CEILING)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - FLOOR: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.FLOOR)}")
    println("using BigDecimal, already defined precision CONTROLED 3 - UP: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 10, RoundingMode.UP)}")
//    println("using BigDecimal, already defined precision CONTROLED - UNNECESSARY: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 3, RoundingMode.UNNECESSARY)}")
    println()
    println("using BigDecimal, already defined precision CONTROLED 0 - HALF_DOWN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.HALF_DOWN)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - HALF_EVEN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.HALF_EVEN)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - HALF_UP: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.HALF_UP)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - DOWN: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.DOWN)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - CEILING: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.CEILING)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - FLOOR: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.FLOOR)}")
    println("using BigDecimal, already defined precision CONTROLED 0 - UP: ${BigDecimal(maxLongPlus10).divide(BigDecimal(maxLongPlus1), 0, RoundingMode.UP)}")
}