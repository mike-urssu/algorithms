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

private val combination = Array(11) { IntArray(11) }

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    setCombination(numbers[0])
    writer.write("${combination[numbers[0]][numbers[1]]}")
    writer.flush()
}

private fun setCombination(n: Int) {
    for (i in 0..n) {
        for (j in 0..i) {
            if (j == 0 || j == i) {
                combination[i][j] = 1
            } else {
                combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j]
            }
        }
    }
}