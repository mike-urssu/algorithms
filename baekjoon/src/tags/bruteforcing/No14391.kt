package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14391
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    println(getMax(n, m))
}

private fun getMax(n: Int, m: Int): Int {
    var max = 0
    for (k in 0 until (1 shl (n * m))) {
        var sum = 0
        for (i in 0 until n) {
            var prefixSum = 0
            for (j in 0 until m) {
                if (k and (1 shl i * m + j) == 0) {
                    prefixSum = prefixSum * 10 + graph[i][j]
                } else {
                    sum += prefixSum
                    prefixSum = 0
                }
            }
            sum += prefixSum
        }

        for (j in 0 until m) {
            var prefixSum = 0
            for (i in 0 until n) {
                if (k and (1 shl i * m + j) != 0) {
                    prefixSum = prefixSum * 10 + graph[i][j]
                } else {
                    sum += prefixSum
                    prefixSum = 0
                }
            }
            sum += prefixSum
        }
        max = max.coerceAtLeast(sum)
    }
    return max
}
