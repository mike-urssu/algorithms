package tags.bruteForce

import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/6491
 */
fun main() {
    val numbers = mutableListOf<Int>()
    while (true) {
        val input = readln().split(" ")
            .filter { it.trim().isNotEmpty() }
            .map { it.toInt() }
        numbers.addAll(input)

        if (numbers.last() == 0) {
            numbers.removeLast()
            break
        }
    }
    numbers.forEach { println("$it ${classifyNumber(it)}") }
}

private fun classifyNumber(number: Int): String {
    if (number == 1) {
        return "DEFICIENT"
    }

    val sum = getFactors(number).sum()
    return if (number == sum) {
        "PERFECT"
    } else if (number > sum) {
        "DEFICIENT"
    } else {
        "ABUNDANT"
    }
}

private fun getFactors(number: Int): List<Int> {
    val factors = mutableListOf<Int>()
    for (i in 1..sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            factors.add(i)
            factors.add(number / i)
        }
    }
    factors.remove(number)
    return factors
}
