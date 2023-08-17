package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/1451
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val prefixSum = getPrefixSum(n, m)
    var max = Long.MIN_VALUE
    max = max.coerceAtLeast(case1(n, m, prefixSum))
    max = max.coerceAtLeast(case2(n, m, prefixSum))
    max = max.coerceAtLeast(case3(n, m, prefixSum))
    max = max.coerceAtLeast(case4(n, m, prefixSum))
    max = max.coerceAtLeast(case5(n, m, prefixSum))
    max = max.coerceAtLeast(case6(n, m, prefixSum))
    println(max)
}

private fun getPrefixSum(n: Int, m: Int): Array<IntArray> {
    val array = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    val prefixSum = Array(n + 1) { IntArray(m + 1) }
    (1..n).forEach { i ->
        (1..m).forEach { j ->
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + array[i - 1][j - 1]
        }
    }
    return prefixSum
}

private fun case1(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (n >= 3) {
        for (i1 in 1 until n - 1) {
            for (i2 in i1 + 1 until n) {
                for (i3 in i2 + 1..n) {
                    val a = prefixSum[i1][m] - prefixSum[0][m]
                    val b = prefixSum[i2][m] - prefixSum[i1][m]
                    val c = prefixSum[i3][m] - prefixSum[i2][m]
                    max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
                }
            }
        }
    }
    return max
}

private fun case2(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (m >= 3) {
        for (j1 in 1 until m - 1) {
            for (j2 in j1 + 1 until m) {
                for (j3 in j2 + 1..m) {
                    val a = prefixSum[n][j1] - prefixSum[n][0]
                    val b = prefixSum[n][j2] - prefixSum[n][j1]
                    val c = prefixSum[n][j3] - prefixSum[n][j2]
                    max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
                }
            }
        }
    }
    return max
}

private fun case3(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (n >= 2 && m >= 2) {
        for (i in 1 until n) {
            for (j in 1 until m) {
                val a = prefixSum[i][j]
                val b = prefixSum[i][m] - prefixSum[i][j]
                val c = prefixSum[n][m] - prefixSum[i][m]
                max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
            }
        }
    }
    return max
}

private fun case4(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (n >= 2 && m >= 2) {
        for (i in 1 until n) {
            for (j in 1 until m) {
                val a = prefixSum[i][m]
                val b = prefixSum[n][j] - prefixSum[i][j]
                val c = prefixSum[n][m] - prefixSum[n][j] - prefixSum[i][m] + prefixSum[i][j]
                max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
            }
        }
    }
    return max
}

private fun case5(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (n >= 2 && m >= 2) {
        for (i in 1 until n) {
            for (j in 1 until m) {
                val a = prefixSum[i][j]
                val b = prefixSum[n][j] - prefixSum[i][j]
                val c = prefixSum[n][m] - prefixSum[n][j]
                max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
            }
        }
    }
    return max
}

private fun case6(n: Int, m: Int, prefixSum: Array<IntArray>): Long {
    var max = Long.MIN_VALUE
    if (n >= 2 && m >= 2) {
        for (i in 1 until n) {
            for (j in 1 until m) {
                val a = prefixSum[n][j]
                val b = prefixSum[i][m] - prefixSum[i][j]
                val c = prefixSum[n][m] - prefixSum[n][j] - prefixSum[i][m] + prefixSum[i][j]
                max = max.coerceAtLeast(a.toLong() * b.toLong() * c.toLong())
            }
        }
    }
    return max
}
