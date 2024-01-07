package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/2749
 */
private val elementaryMatrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
private const val p = 1_000_000

fun main() {
    val n = readln().toLong()
    println(fibonacci(n)[1][0])
}

private fun fibonacci(n: Long): Array<LongArray> {
    if (n == 1L) {
        return elementaryMatrix
    }

    val halfPow = fibonacci(n / 2)
    return if (n % 2 == 0L) {
        halfPow.mul(halfPow)
    } else {
        halfPow.mul(halfPow).mul(elementaryMatrix)
    }
}

private infix fun Array<LongArray>.mul(other: Array<LongArray>): Array<LongArray> {
    val newMatrix = Array(2) { LongArray(2) }
    (0 until 2).forEach { i ->
        (0 until 2).forEach { j ->
            (0 until 2).forEach { k ->
                newMatrix[i][j] = (newMatrix[i][j] + this[i][k] * other[k][j]) % p
            }
        }
    }
    return newMatrix
}
