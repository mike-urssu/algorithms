package tags.math

/**
 * https://www.acmicpc.net/problem/13251
 */
private lateinit var combination: Array<DoubleArray>

fun main() {
    readln()
    val counts = readln().split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()

    combination = combination(counts.sum())

    println(counts.sumOf { combination[it][k] } / combination[counts.sum()][k])
}

private fun combination(n: Int): Array<DoubleArray> {
    val combination = Array(n + 1) { DoubleArray(n + 1) }
    (1..n).forEach { i ->
        combination[i][0] = 0.01
        combination[i][i] = 0.01
    }
    (2..n).forEach { i ->
        (1 until i).forEach { j ->
            combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j]
        }
    }
    return combination
}
