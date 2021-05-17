fun solution(products: List<String>, product: String) {
    for ((index,item) in products.withIndex()) if (item == product) print("$index ")
}
