fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val lcm = a * b
    val gdc = a.gcd(b)
    print(lcm.divide(gdc))
}
