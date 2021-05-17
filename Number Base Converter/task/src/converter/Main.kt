package converter

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import kotlin.math.roundToLong

//implementation only using the info in theory
// ALL TEST PASSED :D
fun main() {
    var firstInput = ""
    var secondInput = ""
    do {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        if (readLine()!!.also { firstInput = it } != "/exit") {
            val (baseFrom, baseTo) = firstInput.split(" ").map { it.toInt() }
            do {
                print("Enter number in base $baseFrom to convert to base $baseTo (To go back type /back) ")
                if (readLine()!!.also { secondInput = it } != "/back") {
                    println("Conversion result: ${numberConversion(baseFrom, baseTo, secondInput)}\n")
                }
            } while (secondInput != "/back")
            println()
        }
    } while (firstInput != "/exit")
}

// Manage the number conversion treatment
fun numberConversion(baseFrom: Int, baseTo: Int, _number: String): String {
    var result = ""
    when {
        baseFrom == baseTo -> result = _number // Dont do anything
        baseFrom == 10 -> result = conversionFromBigDecimalToTargetBase(_number, baseTo) // Converting directly to the baseTo number
        baseFrom != 10 -> { // Convert to decimal then to target base without altering fractional part. If target base is decimal, leave it like that with 5 decimals
            val decimalNumber = conversionFromBaseToBigDecimal(_number, baseFrom)
            result = if (baseTo != 10) conversionFromBigDecimalToTargetBase(decimalNumber, baseTo) else decimalNumber.toBigDecimal().setScale(5,RoundingMode.FLOOR).toString()
        }
    }
    return result
}

// Function to handle any base number with or without fractional into decimal
fun conversionFromBaseToBigDecimal(number: String, _sourceBase: Int): String {
    val sourceBase = _sourceBase.toBigDecimal()
    var total = BigDecimal.ZERO

    // Get mandatory integer part
    var numberPartsArray = number.split(".")
    val integerPart = numberPartsArray[0]

    // Multiplying the value of the number by their respective power base in function of index
    for ((index, value) in integerPart.reversed().withIndex())
        total += (if (sourceBase > 9.toBigDecimal()) hexDigitToDecimal(value.toLowerCase()).toBigDecimal()
                 else value.toString().toBigDecimal()) * sourceBase.pow(index)

    // Check if it has fractional part
    if (numberPartsArray.size > 1){
        val fractionalPart = numberPartsArray[1]

        // Multiplying the value of the fraction number by their respective negative power base in function of index
        for ((index, value) in fractionalPart.withIndex()) {
                total += (if (sourceBase > 9.toBigDecimal()) hexDigitToDecimal(value.toLowerCase()).toBigDecimal()
                else value.toString().toBigDecimal()) * sourceBase.pow(-(index + 1), MathContext(10, RoundingMode.FLOOR))
        }
    }
    return total.toString()
}

// Function that convert decimal number with or without fractional into any base
fun conversionFromBigDecimalToTargetBase(_number: String, _baseTo: Int): String {
    val baseTo = _baseTo.toBigDecimal()
    var result = ""

    // Get mandatory integer part
    var numberPartsArray = _number.split(".")
    var integerPart = numberPartsArray[0].toBigDecimal()

    // Algorithm to convert decimal to any base
    do {
        val (quotient, reminder) = integerPart.setScale(0, RoundingMode.DOWN).divideAndRemainder(baseTo)
        result += if (baseTo > 9.toBigDecimal()) decimalToAlphabetDigit(reminder.toInt()) else reminder.toString()
        integerPart = quotient
    } while (integerPart >= baseTo)
    if (integerPart > BigDecimal.ZERO && baseTo >= BigDecimal.TEN) result += decimalToAlphabetDigit(integerPart.toInt())
    else if (integerPart > BigDecimal.ZERO) result += integerPart.toString()
    result = result.reversed()

    if (numberPartsArray.size > 1 ){
        var rightResult = "."
        var fractionalPart =
            when {
                // Handle cases when fractional is zero
                numberPartsArray[1].toBigDecimal().compareTo(BigDecimal.ZERO) == 0 -> BigDecimal.ZERO // Dont do anything
                numberPartsArray[1].length > 10 -> numberPartsArray[1].substring(0..9).toBigDecimal().movePointLeft(10) // Controlling max decimals
                else -> numberPartsArray[1].toBigDecimal().movePointLeft(numberPartsArray[1].length)
            }
        var decimalLimit = 0

        // Algorithm to fractional part to any base, limit 5 decimals
        while (fractionalPart.compareTo(BigDecimal.ZERO) != 0 && decimalLimit < 5) {
            fractionalPart *= baseTo
            val (integer, fraction) = getIntegerAndFractionalPart(fractionalPart.toString())
            rightResult += if (baseTo > 9.toBigDecimal()) decimalToAlphabetDigit(integer.toInt()) else integer.toString()
            decimalLimit++
            fractionalPart = fraction
        }
        //If we have 0, set right part to it because is empty
        if (rightResult == ".") rightResult = ".0"
        else {
            // I got my mind dry. This is what I came up for result xxx.01111 > xxx.10000
            if (rightResult[1] == '0' &&
                rightResult[2] != '0' &&
                rightResult[3] != '0' &&
                rightResult[4] != '0' &&
                rightResult[5] != '0' &&
                rightResult[2] == rightResult[3] && rightResult[3] == rightResult[4] && rightResult[4] == rightResult[5])
                rightResult = ".1"
        }
        // Fulfilling with zeros
        while (rightResult.length < 6) {
            rightResult += "0"
        }
        result += rightResult
    }
    return result
}

fun getIntegerAndFractionalPart(number: String): Array<BigDecimal> {
    val (integerStr,fractionalStr) = number.split(".")
    return arrayOf(integerStr.toBigDecimal(), fractionalStr.toBigDecimal().movePointLeft(fractionalStr.length))
}

fun decimalToAlphabetDigit(number: Int): String {
    return when(number) {
        10 -> "a"
        11 -> "b"
        12 -> "c"
        13 -> "d"
        14 -> "e"
        15 -> "f"
        16 -> "g"
        17 -> "h"
        18 -> "i"
        19 -> "j"
        20 -> "k"
        21 -> "l"
        22 -> "m"
        23 -> "n"
        24 -> "o"
        25 -> "p"
        26 -> "q"
        27 -> "r"
        28 -> "s"
        29 -> "t"
        30 -> "u"
        31 -> "v"
        32 -> "w"
        33 -> "x"
        34 -> "y"
        35 -> "z"
        else -> number.toString()
    }
}
fun hexDigitToDecimal(number: Char): Int {
    return when(number) {
         'a' -> 10
         'b' -> 11
         'c' -> 12
         'd' -> 13
         'e' -> 14
         'f' -> 15
         'g' -> 16
         'h' -> 17
         'i' -> 18
         'j' -> 19
         'k' -> 20
         'l' -> 21
         'm' -> 22
         'n' -> 23
         'o' -> 24
         'p' -> 25
         'q' -> 26
         'r' -> 27
         's' -> 28
         't' -> 29
         'u' -> 30
         'v' -> 31
         'w' -> 32
         'x' -> 33
         'y' -> 34
         'z' -> 35
        else -> number.toString().toInt()
    }
}