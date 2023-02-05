package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1769
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var number = reader.readLine()
    var cycle = 0
    var sum = number.sumOf { it.digitToInt() }
    while (number.length > 1) {
        cycle++
        sum = number.sumOf { it.digitToInt() }
        number = sum.toString()
    }

    writer.write("$cycle\n")
    if (sum % 3 == 0) {
        writer.write("YES")
    } else {
        writer.write("NO")
    }
    writer.flush()
}