package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1380
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var scenario = 1
    while (true) {
        val numberOfStudent = reader.readLine().toInt()
        if (numberOfStudent == 0) {
            break
        }

        val names = Array(numberOfStudent) { reader.readLine() }
        val counts = IntArray(numberOfStudent) { 2 }

        repeat(numberOfStudent * 2 - 1) {
            val call = reader.readLine().split(" ")
            counts[call[0].toInt() - 1]--
        }

        for (i in counts.indices) {
            if (counts[i] == 1) {
                writer.write("${scenario++} ${names[i]}\n")
            }
        }
    }
    writer.flush()
}