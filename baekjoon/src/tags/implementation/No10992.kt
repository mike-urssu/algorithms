package tags.implementation

/**
 * https://www.acmicpc.net/problem/10992
 */
fun main() {
    val n = readln().toInt()
    val stars = Array(n) { CharArray(2 * n - 1) { ' ' } }
    val center = n - 1
    (0 until n - 1).forEach { i ->
        stars[i][center - i] = '*'
        stars[i][center + i] = '*'
    }
    (0 until 2 * n - 1).forEach { j -> stars[n - 1][j] = '*' }
    stars.forEach { println(it.joinToString("").trimEnd()) }
}
