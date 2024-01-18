package tags.math

/**
 * https://www.acmicpc.net/problem/2460
 */
fun main() {
    var max = 0
    var currentPeople = 0
    repeat(10) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        currentPeople = currentPeople - n + m
        max = max.coerceAtLeast(currentPeople)
    }
    println(max)
}
