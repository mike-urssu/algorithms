package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/11444
 */
private val defaultMatrix =
    arrayOf(
        longArrayOf(1, 1),
        longArrayOf(1, 0)
    )

fun main() {
    val n = readln().toLong()
    println(getFibonacci(n))
}

private fun getFibonacci(n: Long): Long {
    val matrix = pow(n)
    return matrix[1][0]
}

private fun pow(n: Long): Array<LongArray> {
    if (n == 1L) {
        return defaultMatrix
    }

    val halfPow = pow(n / 2)
    return if (n % 2 == 0L) {
        mul(halfPow, halfPow)
    } else {
        mul(defaultMatrix, mul(halfPow, halfPow))
    }
}

private fun mul(m1: Array<LongArray>, m2: Array<LongArray>): Array<LongArray> {
    val matrix = Array(2) { LongArray(2) }
    (0 until 2).forEach { i ->
        (0 until 2).forEach { j ->
            (0 until 2).forEach { k ->
                matrix[i][j] = (matrix[i][j] + m1[i][k] * m2[k][j]) % 1000000007
            }
        }
    }
    return matrix
}
