package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

/**
 * https://www.acmicpc.net/problem/1271
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { BigInteger(it) }
    writer.write("${numbers[0].div(numbers[1])}\n")
    writer.write("${numbers[0].mod(numbers[1])}")
    writer.flush()
}