package tags.bfs

/**
 * https://www.acmicpc.net/problem/14395
 */
import java.util.PriorityQueue

fun main() {
    val (s, t) = readln().split(" ").map { it.toLong() }
    println(findOperations(s, t))
}

private fun findOperations(s: Long, t: Long): String {
    if (s == t) {
        return "0"
    }

    val queue = PriorityQueue<Pair<Long, String>> { it, other ->
        val c1 = it.second.length.compareTo(other.second.length)
        if (c1 == 0) {
            it.second.compareTo(other.second)
        } else {
            c1
        }
    }
    queue.add(s to "")
    queue.add(s * s to "*")
    queue.add(0L to "-")
    queue.add(1L to "/")
    val isVisited = mutableSetOf<Long>().apply { this.addAll(listOf(s, s * s, 0L, 1L)) }

    while (queue.isNotEmpty()) {
        val (v, o) = queue.poll()
        if (v > t) {
            continue
        }

        if (v == t) {
            return o
        }
        if (!isVisited.contains(v * v)) {
            isVisited.add(v * v)
            queue.add(v * v to "$o*")
        }
        if (!isVisited.contains(v + v)) {
            isVisited.add(v + v)
            queue.add(v + v to "$o+")
        }
    }

    return "-1"
}
