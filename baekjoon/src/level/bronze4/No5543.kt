package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5543
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val burger1 = reader.readLine().toInt()
    val burger2 = reader.readLine().toInt()
    val burger3 = reader.readLine().toInt()
    val drink1 = reader.readLine().toInt()
    val drink2 = reader.readLine().toInt()
    writer.write("${burger1.coerceAtMost(burger2).coerceAtMost(burger3) + drink1.coerceAtMost(drink2) - 50}")
    writer.flush()
}
