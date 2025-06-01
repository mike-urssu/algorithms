package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/12850
 */
private val defaultMatrix = arrayOf(
    longArrayOf(0, 1, 1, 0, 0, 0, 0, 0),
    longArrayOf(1, 0, 1, 1, 0, 0, 0, 0),
    longArrayOf(1, 1, 0, 1, 1, 0, 0, 0),
    longArrayOf(0, 1, 1, 0, 1, 1, 0, 0),
    longArrayOf(0, 0, 1, 1, 0, 1, 0, 1),
    longArrayOf(0, 0, 0, 1, 1, 0, 1, 0),
    longArrayOf(0, 0, 0, 0, 0, 1, 0, 1),
    longArrayOf(0, 0, 0, 0, 1, 0, 1, 0)
)

private const val MOD = 1_000_000_007

fun main() {
    val d = readln().toInt()
    val matrix = divideAndConquer(d)
    println(matrix[0][0])
}

private fun divideAndConquer(n: Int): Array<LongArray> {
    if (n == 1) {
        return defaultMatrix
    }
    val half = divideAndConquer(n / 2)
    return if (n % 2 == 1) {
        half.multiply(half).multiply(defaultMatrix)
    } else {
        half.multiply(half)
    }
}

private fun Array<LongArray>.multiply(matrix: Array<LongArray>): Array<LongArray> {
    val newMatrix = Array(8) { LongArray(8) }
    (0 until 8).forEach { i ->
        (0 until 8).forEach { j ->
            (0 until 8).forEach { k ->
                newMatrix[i][j] = (newMatrix[i][j] + this[i][k] * matrix[k][j]) % MOD
            }
        }
    }
    return newMatrix
}
