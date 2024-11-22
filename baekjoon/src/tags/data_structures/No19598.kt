package tags.data_structures

/**
 * https://www.acmicpc.net/problem/19598
 */
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val times = Array(n) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        from to to
    }.sortedWith { it, other ->
        val c1 = -it.second.compareTo(other.second)
        if (c1 != 0) {
            c1
        } else {
            -it.first.compareTo(other.first)
        }
    }

    val queue = PriorityQueue<Pair<Int, Int>> { it, other ->
        val c1 = -it.first.compareTo(other.first)
        if (c1 != 0) {
            c1
        } else {
            it.second.compareTo(other.second)
        }
    }
    queue.add(times[0])
    (1 until n).forEach { i ->
        val (from, to) = times[i]
        if (queue.peek().first < to) {
            queue.add(times[i])
        } else {
            val (_, t) = queue.poll()
            queue.add(from to t)
        }
    }
    println(queue.size)
}
