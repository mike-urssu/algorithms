package level.bronze3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2010
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    var plug = reader.readLine().toInt()
    repeat(numberOfInput - 1) { plug += reader.readLine().toInt() - 1 }
    writer.write("$plug")
    writer.flush()
}
