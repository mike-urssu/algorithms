package tags.math

/**
 * https://www.acmicpc.net/problem/4344
 */
fun main() {
    val c = readln().toInt()
    repeat(c) {
        val input = readln().split(" ").map { it.toInt() }
        val n = input[0]
        val scores = input.drop(1)
        val average = scores.average()
        val overAverage = scores.count { it > average }
        println("${String.format("%.3f", overAverage * 100.0 / n)}%")
    }
}
