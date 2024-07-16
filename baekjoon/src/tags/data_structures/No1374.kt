package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1374
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val schedules = Array(n) {
        val (_, start, end) = readln().split(" ").map { it.toInt() }
        start to end
    }.sortedWith { it, other ->
        val c1 = it.first.compareTo(other.first)
        if (c1 == 0) {
            it.second.compareTo(other.second)
        } else {
            c1
        }
    }

    val timelines = PriorityQueue<Int>().apply { this.add(schedules[0].second) }
    (1 until n).forEach { i ->
        val (start, end) = schedules[i]
        if (timelines.peek() <= start) {
            timelines.poll()
        }
        timelines.add(end)
    }
    println(timelines.size)
}
