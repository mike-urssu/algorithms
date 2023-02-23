package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1051
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val rectangle = Array(n) { readln().toCharArray() }

    var length = 0
    for (i in 0 until n.coerceAtMost(m)) {
        for (j in 0 until n - i) {
            for (k in 0 until m - i) {
                val points = setOf(rectangle[j][k], rectangle[j + i][k], rectangle[j + i][k + i], rectangle[j][k + i])
                if (points.size == 1) {
                    length = i + 1
                }
            }
        }
    }

    println(length * length)
}
