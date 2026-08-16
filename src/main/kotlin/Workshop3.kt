package org.example

fun main() {

}

fun validateCitizenId(id: String): Boolean {
    if (!id.all { it.isDigit() } || id.length != 13) {
        return false
    }

    val digits = id.map { it.digitToInt() }

    var sum = 0
    for (i in 0 until 12) {
        sum += digits[i] * (13 - i)
    }

    val checkDigit = (11 - (sum % 11)) % 10

    return checkDigit == digits[12]
}