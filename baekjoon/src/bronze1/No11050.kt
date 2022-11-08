package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11050
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private val combination = Array(11) { IntArray(11) { -1 } }

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    repeat(11) { i ->
        combination[i][0] = 1
        combination[i][i] = 1
    }
    writer.write("${getCombination(numbers[0], numbers[1])}")
    writer.flush()
}

private fun getCombination(n: Int, r: Int): Int {
    if (r == 0 || r == n) {
        return 1
    }

    if (combination[n - 1][r - 1] == -1) {
        setCombination(n - 1, r - 1)
    }

    if (combination[n - 1][r] == -1) {
        setCombination(n - 1, r)
    }

    return getCombination(n - 1, r - 1) + getCombination(n - 1, r)
}

private fun setCombination(n: Int, r: Int) {
    combination[n][r] = getCombination(n - 1, r - 1) + getCombination(n - 1, r)
}