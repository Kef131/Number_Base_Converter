fun main() {
    val numberCompanies = readLine()!!.toInt()
    val arrayCompanies = IntArray(numberCompanies)
    val arrayTaxes = IntArray(numberCompanies)
    var highestTaxesPaymentCompany = 0
    var majorTax = 0.0
    for (i in 0 until numberCompanies) {
        arrayCompanies[i] = readLine()!!.toInt()
    }
    for (i in 0 until numberCompanies) {
        arrayTaxes[i] = readLine()!!.toInt()
    }
    for (i in 0 until numberCompanies) {
        val currentPayTax = arrayCompanies[i] * (arrayTaxes[i].toDouble() / 100)
        if (currentPayTax >= majorTax) {
            if (!(currentPayTax == majorTax && highestTaxesPaymentCompany < i)) {
                highestTaxesPaymentCompany = i
            }
            majorTax = currentPayTax
        }
    }
    print(highestTaxesPaymentCompany + 1)
}