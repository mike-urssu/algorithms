package greedy

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
    val schedules = arrayListOf<IntArray>()
    for (i in 0 until numberOfInput) {
        val schedule = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        schedules.add(schedule)
    }
    schedules.sortWith(compareBy({ it[0] }, { it[1] }))

    writer.write(getMinimumRoomCount(schedules).toString())
    writer.flush()
}

fun getMinimumRoomCount(schedules: List<IntArray>): Int {
    val queue = PriorityQueue<Int>()
    queue.add(schedules[0][1])
    for (i in 1 until schedules.size) {
        if (queue.peek() <= schedules[i][0])
            queue.poll()
        queue.add(schedules[i][1])
    }
    return queue.size
}

/**
 * 시간 초과
 */
fun getMinimumRoomCount2(schedules: List<IntArray>): Int {
    val rooms = mutableListOf<IntArray>()
    rooms.add(schedules[0])
    for (i in 1 until schedules.size) {
        var index = 0
        for (j in rooms.indices) {
            if (schedules[i][0] == rooms[j][1]) {
                rooms[j][1] = schedules[i][1]
                break
            }
            index++
        }
        if (index == rooms.size)
            rooms.add(schedules[i])
    }
    return rooms.size
}