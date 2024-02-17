package tags.math

/**
 * https://www.acmicpc.net/problem/2592
 */
fun main() {
    val numbers = IntArray(1001)
    repeat(10) {
        val n = readln().toInt()
        numbers[n]++
    }

    val mean = numbers.indices.sumOf { it * numbers[it] } / 10
    val mode = numbers.indexOf(numbers.max())
    println(mean)
    println(mode)
}
