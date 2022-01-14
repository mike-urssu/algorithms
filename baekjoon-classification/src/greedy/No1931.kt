package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1931
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val schedules = arrayListOf<Array<Int>>()
    val numberOfInput = reader.readLine().toInt()
    for (i in 0 until numberOfInput)
        schedules.add(reader.readLine().split(' ').map { time -> time.toInt() }.toTypedArray())

    schedules.sortWith(compareBy({ it[1] }, { it[0] }))

    var count = 1
    var endAt = schedules[0][1]
    for (i in 1 until schedules.size) {
        if (schedules[i][0] >= endAt) {
            endAt = schedules[i][1]
            count++
        }
    }
    writer.write(count.toString())
    writer.flush()
}
