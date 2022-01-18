package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4796
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    var case = 1
    while (true) {
        val input = reader.readLine()
        if (input.equals("0 0 0"))
            break
        val days = input.split(' ').map { it.toInt() }

        val vacation = days[2] / days[1] * days[0] +
                if (days[2] % days[1] > days[0]) days[0]
                else days[2] % days[1]
        writer.write("Case ${case++}: $vacation")
        writer.newLine()
    }
    writer.flush()
}
