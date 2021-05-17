fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    var (q, r) = a.divideAndRemainder(b)
    println("$a = $b*$q + $r")
}