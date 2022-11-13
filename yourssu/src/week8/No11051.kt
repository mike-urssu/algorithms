package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11051
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var combination: Array<IntArray>

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    setCombinations()
    writer.write("${combination[numbers[0]][numbers[1]]}")
    writer.flush()
}

private fun setCombinations() {
    combination = Array(1001) { IntArray(1001) }
    for (i in 0..1000) {
        for (j in 0..i) {
            if (j == 0 || j == i) {
                combination[i][j] = 1
            } else {
                combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % 10007
            }
        }
    }
}
