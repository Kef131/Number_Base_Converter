fun main() {
    val aArray = IntArray(readLine()!!.toInt()) { readLine()!!.toInt() }
    print("${aArray[aArray.lastIndex]} ")
    for (i in 0..aArray.lastIndex - 1) {
        print("${aArray[i]} ")
    }
}
