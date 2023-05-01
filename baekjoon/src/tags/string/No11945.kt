package tags.string

/**
 * https://www.acmicpc.net/problem/11945
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arrays = Array(n) { readln().toCharArray() }
    (0 until n).forEach { i ->
        (m - 1 downTo 0).forEach { j -> print(arrays[i][j]) }
        println()
    }
}
