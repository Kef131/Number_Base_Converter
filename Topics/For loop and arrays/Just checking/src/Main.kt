fun main() {
    val numbers = IntArray(readLine()!!.toInt())
    repeat(numbers.size) {
        numbers[it] = readLine()!!.toInt()
    }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }
    var (isP, isM) = arrayOf(false, false)
    for (number in numbers) {
        if (p == number) isP = true
        if (m == number) isM = true
    }
    println(if (isP && isM) "YES" else "NO")
}