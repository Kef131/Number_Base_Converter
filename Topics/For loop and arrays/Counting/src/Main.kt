fun main() {
    val n = readLine()!!.toInt()
    val intArray = IntArray(n)
    for (i in 0 until n) {
        intArray[i] = readLine()!!.toInt()
        }
    val m = readLine()!!.toInt()
    var counter = 0
    for (value in intArray) {
        if (m == value) {
            counter++
        }
    }
    print(counter)
}
