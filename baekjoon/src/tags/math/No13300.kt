package tags.math

/**
 * https://www.acmicpc.net/problem/13300
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val grades = Array(2) { IntArray(7) }
    repeat(n) {
        val (s, y) = readln().split(" ").map { it.toInt() }
        grades[s][y]++
    }

    val rooms = grades.sumOf { row -> row.sumOf { (it + k - 1) / k } }
    println(rooms)
}
