package tags.implementation

/**
 * https://www.acmicpc.net/problem/4592
 */
fun main() {
    while (true) {
        val input = readln().split(" ").map { it.toInt() }
        val n = input[0]
        if (n == 0) {
            break
        }

        val numbers = input.drop(1)
        println("${distinct(numbers).joinToString(" ")} $")
    }
}

private fun distinct(numbers: List<Int>): List<Int> {
    val distinctNumbers = mutableListOf<Int>()
    distinctNumbers.add(numbers[0])
    (1 until numbers.size).forEach { i ->
        if (numbers[i] != numbers[i - 1]) {
            distinctNumbers.add(numbers[i])
        }
    }
    return distinctNumbers
}
