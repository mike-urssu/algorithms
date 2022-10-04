package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4999
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val aah = reader.readLine()
    val aah2 = reader.readLine()
    writer.write(if (aah.endsWith(aah2)) "go" else "no")
    writer.flush()
}