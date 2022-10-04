package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/3003
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val pieces = intArrayOf(1, 1, 2, 2, 2, 8)
    val givenPieces = reader.readLine().split(" ").map { it.toInt() }
    for (i in pieces.indices) {
        writer.write("${pieces[i] - givenPieces[i]} ")
    }
    writer.flush()
}