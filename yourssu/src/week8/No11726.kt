package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11726
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    val tiles = IntArray(1001)
    tiles[1] = 1
    tiles[2] = 2
    for (i in 3..1000) {
        tiles[i] = (tiles[i - 2] + tiles[i - 1]) % 10007
    }
    writer.write("${tiles[number]}")
    writer.flush()
}