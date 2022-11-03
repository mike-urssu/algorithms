package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/12847
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val n = numbers[0]
    val m = numbers[1]
    val benefits = reader.readLine().split(" ").map { it.toLong() }

    var sum = 0L
    for (i in 0 until m) {
        sum += benefits[i]
    }

    var lowIndex = 0
    var highIndex = m
    var max = sum
    while (highIndex < n) {
        sum -= benefits[lowIndex]
        sum += benefits[highIndex]
        max = max.coerceAtLeast(sum)

        lowIndex++
        highIndex++
    }

    writer.write("$max")
    writer.flush()
}