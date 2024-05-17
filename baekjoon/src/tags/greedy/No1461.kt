package tags.greedy

/**
 * https://www.acmicpc.net/problem/1461
 */
import kotlin.math.absoluteValue

fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    val positiveNumbers = numbers.filter { it > 0 }.sorted()
    val negativeNumbers = numbers.filter { it < 0 }.map { it.absoluteValue }.sorted()
    println(minOf(getDistance1(m, positiveNumbers, negativeNumbers), getDistance2(m, positiveNumbers, negativeNumbers)))
}

private fun getDistance1(m: Int, positiveNumbers: List<Int>, negativeNumbers: List<Int>): Int {
    var distance = 0
    if (negativeNumbers.isNotEmpty()) {
        val index = (negativeNumbers.size - 1) % m
        distance += (index until negativeNumbers.size step m).sumOf { negativeNumbers[it] * 2 }
    }
    if (positiveNumbers.isNotEmpty()) {
        val index = (positiveNumbers.size - 1) % m
        distance += (index until positiveNumbers.size - m step m).sumOf { positiveNumbers[it] * 2 }
        distance += positiveNumbers.last()
    }
    return distance
}

private fun getDistance2(m: Int, positiveNumbers: List<Int>, negativeNumbers: List<Int>): Int {
    var distance = 0
    if (positiveNumbers.isNotEmpty()) {
        val index = (positiveNumbers.size - 1) % m
        distance += (index until positiveNumbers.size step m).sumOf { positiveNumbers[it] * 2 }
    }
    if (negativeNumbers.isNotEmpty()) {
        val index = (negativeNumbers.size - 1) % m
        distance += (index until negativeNumbers.size - m step m).sumOf { negativeNumbers[it] * 2 }
        distance += negativeNumbers.last()
    }
    return distance
}
