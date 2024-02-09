package tags.implementation

/**
 * https://www.acmicpc.net/problem/10990
 */
fun main() {
    val n = readln().toInt()
    val lines = Array(n) { CharArray(2 * n - 1) { ' ' } }
    (0 until n).forEach { i ->
        lines[i][n - 1 - i] = '*'
        lines[i][n - 1 + i] = '*'
    }
    lines.forEach { println(it.joinToString("").trimEnd()) }
}
