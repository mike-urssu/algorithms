package tags.exponentiation_by_squaring

/**
 * https://www.acmicpc.net/problem/11442
 */
fun main() {
    val n = readln().toLong()
    if (n % 2 == 0L) {
        println(fibonacci(n))
    } else {
        println(fibonacci(n + 1))
    }
}

private fun fibonacci(n: Long) =
    getMatrix(n)[0][1]

private val elementaryMatrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

private fun getMatrix(n: Long): Array<LongArray> {
    if (n == 1L) {
        return elementaryMatrix
    }

    val half = getMatrix(n / 2)
    return if (n % 2 == 0L) {
        half.mul(half)
    } else {
        half.mul(half).mul(elementaryMatrix)
    }
}

private const val MOD = 1_000_000_007

private infix fun Array<LongArray>.mul(other: Array<LongArray>): Array<LongArray> {
    val newMatrix = Array(2) { LongArray(2) }
    newMatrix[0][0] = (this[0][0] * other[0][0] + this[0][1] * other[1][0]) % MOD
    newMatrix[0][1] = (this[0][0] * other[0][1] + this[0][1] * other[1][1]) % MOD
    newMatrix[1][0] = (this[1][0] * other[0][0] + this[1][1] * other[1][0]) % MOD
    newMatrix[1][1] = (this[1][0] * other[0][1] + this[1][1] * other[1][1]) % MOD
    return newMatrix
}
