package tags.sorting

/**
 * https://www.acmicpc.net/problem/1377
 */
fun main() {
    val n = readln().toInt()
    val numbers = (1..n).map { i -> readln().toInt() to i }
    val movedIndices = numbers.sortedBy { it.first }.mapIndexed { j, (_, i) -> i - (j + 1) }
    println(movedIndices.max() + 1)
}
