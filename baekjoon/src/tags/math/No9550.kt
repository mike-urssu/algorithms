package tags.math

/**
 * https://www.acmicpc.net/problem/9550
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (_, k) = readln().split(" ").map { it.toInt() }
        val candies = readln().split(" ").map { it.toInt() }.toIntArray()
        println(candies.sumOf { it / k })
    }
}
