package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/2086
 */
private const val MOD = 1_000_000_000
private val defaultMatrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val sum = (fibonacci(b + 2) - 1) - (fibonacci(a + 1) - 1)
    println((MOD + sum) % MOD)
}

private fun fibonacci(n: Long) =
    getMatrix(n)[1][0]

private fun getMatrix(n: Long): Array<LongArray> {
    if (n == 1L) {
        return defaultMatrix
    }

    val half = getMatrix(n / 2)
    return if (n % 2 == 0L) {
        half.mul(half)
    } else {
        half.mul(half).mul(defaultMatrix)
    }
}

private infix fun Array<LongArray>.mul(other: Array<LongArray>): Array<LongArray> {
    val newMatrix = Array(2) { LongArray(2) }
    (0..1).forEach { i ->
        (0..1).forEach { j ->
            (0..1).forEach { k ->
                newMatrix[i][j] = (newMatrix[i][j] + this[i][k] * other[k][j]) % MOD
            }
        }
    }
    return newMatrix
}
