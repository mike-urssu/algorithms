package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/11660
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val prefixArray = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            prefixArray[i][j] =
                array[i - 1][j - 1] + prefixArray[i - 1][j] + prefixArray[i][j - 1] - prefixArray[i - 1][j - 1]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        println(prefixArray[x2][y2] - prefixArray[x1 - 1][y2] - prefixArray[x2][y1 - 1] + prefixArray[x1 - 1][y1 - 1])
    }
}
