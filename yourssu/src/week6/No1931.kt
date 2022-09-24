package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/1931
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val schedules = PriorityQueue<Schedule> { it, other ->
        if (it.to != other.to)
            it.to.compareTo(other.to)
        else
            it.from.compareTo(other.from)
    }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val times = reader.readLine().split(" ").map { it.toInt() }
        schedules.add(Schedule(times[0], times[1]))
    }

    var countOfSchedules = 0
    var last = -1
    while (schedules.isNotEmpty()) {
        val schedule = schedules.poll()
        if (schedule.from >= last) {
            countOfSchedules++
            last = schedule.to
        }
    }

    writer.write("$countOfSchedules")
    writer.flush()
}

private class Schedule(
    val from: Int,
    val to: Int
)