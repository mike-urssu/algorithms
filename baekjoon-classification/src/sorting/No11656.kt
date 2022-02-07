package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11656
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val word = reader.readLine()
    val prefixes = arrayListOf<String>()
    for (i in word.indices) {
        val prefix = word.substring(i)
        prefixes.add(prefix)
    }

    prefixes.sort()

    for (prefix in prefixes) {
        writer.write(prefix)
        writer.newLine()
    }
    writer.flush()
}
