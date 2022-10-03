package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2738
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    val a = Array(size[0]) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val b = Array(size[0]) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until size[0]) {
        for (j in 0 until size[1]) {
            writer.write("${a[i][j] + b[i][j]} ")
        }
        writer.newLine()
    }
    writer.flush()
}