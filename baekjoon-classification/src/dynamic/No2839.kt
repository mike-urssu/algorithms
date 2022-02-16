package dynamic

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2839
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val weight = reader.readLine().toInt()
    var count = -1
    for (i in weight / 5 downTo 0) {
        if ((weight - 5 * i) % 3 == 0) {
            count = i + (weight - 5 * i) / 3
            break
        }
    }

    writer.write(count.toString())
    writer.flush()
}
