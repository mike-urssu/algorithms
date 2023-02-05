package level.bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1075
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt() / 100 * 100
    val f = reader.readLine().toInt()
    val mod = (f - (n % f)) % f
    writer.write(String.format("%02d", mod))
    writer.flush()
}