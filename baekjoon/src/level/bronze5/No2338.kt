package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/2338
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val a = BigInteger(reader.readLine())
    val b = BigInteger(reader.readLine())
    writer.write("${a + b}\n")
    writer.write("${a - b}\n")
    writer.write("${a * b}")
    writer.flush()
}