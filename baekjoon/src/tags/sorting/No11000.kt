package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11000
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val schedules = arrayListOf<List<Int>>()
    for (i in 0 until numberOfInput) {
        val schedule = reader.readLine().split(' ').map { it.toInt() }
        schedules.add(schedule)
    }
    schedules.sortWith(compareBy({ it[0] }, { it[1] }))

    val queue = PriorityQueue<Int>()
    for (schedule in schedules) {
        if (queue.isNotEmpty()) {
            val endAt = queue.peek()
            if (endAt <= schedule[0])
                queue.poll()
        }
        queue.add(schedule[1])
    }
    writer.write(queue.size.toString())
    writer.flush()
}
