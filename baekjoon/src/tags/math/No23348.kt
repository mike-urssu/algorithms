package tags.math

/**
 * https://www.acmicpc.net/problem/23348
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    val scores = IntArray(n) {
        var sum = 0
        repeat(3) {
            val (c1, c2, c3) = readln().split(" ").map { it.toInt() }
            sum += c1 * a + c2 * b + c3 * c
        }
        sum
    }
    println(scores.max())
}
