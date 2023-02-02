package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5532
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val l = reader.readLine().toInt()
    val math = reader.readLine().toInt()
    val korean = reader.readLine().toInt()
    val m = reader.readLine().toInt()
    val k = reader.readLine().toInt()
    writer.write("${l - ((math - 1) / m).coerceAtLeast((korean - 1) / k) - 1}")
    writer.flush()
}
