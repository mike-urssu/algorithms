package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/12841
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val cross = reader.readLine().split(" ").map { it.toLong() }
    val s = reader.readLine().split(" ").map { it.toLong() }
    val d = reader.readLine().split(" ").map { it.toLong() }

    val accS = LongArray(n)
    for (i in 1 until n) {
        accS[i] = accS[i - 1] + s[i - 1]
    }
    val accD = LongArray(n)
    for (i in 1 until n) {
        accD[i] = accD[i - 1] + d[i - 1]
    }

    var minIndex = 0
    var minDistance = Long.MAX_VALUE
    for (i in 0 until n) {
        val distance = accS[i] + cross[i] + (accD[n - 1] - accD[i])
        if (minDistance > distance) {
            minIndex = i
            minDistance = distance
        }
    }

    writer.write("${minIndex + 1} $minDistance")
    writer.flush()
}