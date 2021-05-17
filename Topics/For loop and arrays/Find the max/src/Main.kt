fun main() {
    val numbers = IntArray(readLine()!!.toInt()) { readLine()!!.toInt() }
    var indexMax = 0
    var max = 0
    for ((index, value) in numbers.withIndex()) {
        if (value > max) {
            max = value
            indexMax = index
        }
    }
    print(indexMax)
}