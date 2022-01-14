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
    for (i in 0 until numberOfInput) {
        val schedule = reader.readLine().split(' ')
        schedules.add(arrayOf(schedule[0].toInt(), schedule[1].toInt()))
    }

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
