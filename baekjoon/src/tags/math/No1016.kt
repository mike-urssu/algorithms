package tags.math

/**
 * https://www.acmicpc.net/problem/1016
 */
fun main() {
    val (min, max) = readln().split(" ").map { it.toLong() }
    println((max - min + 1) - countInvalidNumbers(min, max))
}

private fun countInvalidNumbers(min: Long, max: Long): Int {
    val invalidNumbers = mutableSetOf<Long>()
    var n = 2L

    while (true) {
        val square = n * n
        if (square > max) {
            break
        }

        ((min + square - 1) / square..max / square).forEach { i -> invalidNumbers.add(square * i) }
        n++
    }

    return invalidNumbers.size
}
