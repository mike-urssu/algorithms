package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/14928
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine()
    var remainder = 0
    for (digit in number) {
        remainder = (remainder * 10 + digit.digitToInt()) % 20000303
    }
    writer.write("$remainder")
    writer.flush()
}