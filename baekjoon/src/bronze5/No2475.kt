package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/2475
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val sum = reader.readLine().split(" ").sumOf { it.toDouble().pow(2) }.toInt()
    writer.write("${sum % 10}")
    writer.flush()
}