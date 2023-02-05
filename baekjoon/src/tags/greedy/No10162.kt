package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10162
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var second = reader.readLine().toInt()
    if (second % 10 != 0) {
        writer.write((-1).toString())
        writer.flush()
        return
    }

    val timers = arrayOf(300, 60, 10)
    for (timer in timers) {
        writer.write("${second / timer} ")
        second %= timer
    }

    writer.flush()
}
