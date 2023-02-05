package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2740
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val sizeA = reader.readLine().split(" ").map { it.toInt() }
    val a = Array(sizeA[0]) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val sizeB = reader.readLine().split(" ").map { it.toInt() }
    val b = Array(sizeB[0]) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val c = multiply(sizeA, a, sizeB, b)
    c.forEach { numbers ->
        numbers.forEach { writer.write("$it ") }
        writer.newLine()
    }
    writer.flush()
}

private fun multiply(sizeA: List<Int>, a: Array<IntArray>, sizeB: List<Int>, b: Array<IntArray>): Array<IntArray> {
    val c = Array(sizeA[0]) { IntArray(sizeB[1]) }
    for (i in 0 until sizeA[0]) {
        for (j in 0 until sizeB[1]) {
            for (k in 0 until sizeA[1]) {
                c[i][j] += a[i][k] * b[k][j]
            }
        }
    }
    return c
}
