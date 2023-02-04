package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Locale

/**
 * https://www.acmicpc.net/problem/5524
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        writer.write("${reader.readLine().lowercase(Locale.getDefault())}\n")
    }
    writer.flush()
}
