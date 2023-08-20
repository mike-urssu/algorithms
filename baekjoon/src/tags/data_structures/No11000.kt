package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11000
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val schedules = Array(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        Pair(s, t)
    }.sortedArrayWith(compareBy({ it.first }, { it.second }))

    val priorityQueue = PriorityQueue<Int>()
    for (schedule in schedules) {
        if (priorityQueue.isNotEmpty()) {
            if (priorityQueue.peek() <= schedule.first) {
                priorityQueue.poll()
            }
        }
        priorityQueue.add(schedule.second)
    }
    println(priorityQueue.size)
}
