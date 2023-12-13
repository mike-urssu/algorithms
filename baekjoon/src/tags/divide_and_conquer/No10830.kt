package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/10830
 */
private var n = 0
private lateinit var matrix: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toLong() }
    n = input[0].toInt()
    val b = input[1]
    matrix = Array(n) { readln().split(" ").map { it.toInt() % 1000 }.toIntArray() }

    val newGraph = pow(b)
    newGraph.forEach { println(it.joinToString(" ")) }
}

private fun pow(b: Long): Array<IntArray> {
    if (b == 1L) {
        return matrix
    }

    val halfPow = pow(b / 2)
    return if (b % 2 == 0L) {
        mul(halfPow, halfPow)
    } else {
        mul(matrix, mul(halfPow, halfPow))
    }
}

private fun mul(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    val matrix = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                matrix[i][j] = (matrix[i][j] + matrix1[i][k] * matrix2[k][j]) % 1000
            }
        }
    }
    return matrix
}
