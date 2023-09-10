package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/13549
 */
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }
    val distances = IntArray(100001) { Int.MAX_VALUE }

    distances[n] = 0
    queue.add(Pair(n, 0))
    while (queue.isNotEmpty()) {
        val (v, u) = queue.poll()
        if (v == k) {
            break
        }

        if (v * 2 <= 100000 && distances[v * 2] > u) {
            distances[v * 2] = u
            queue.add(Pair(v * 2, u))
        }

        if (v + 1 <= 100000 && distances[v + 1] > u + 1) {
            distances[v + 1] = u + 1
            queue.add(Pair(v + 1, u + 1))
        }

        if (v - 1 >= 0 && distances[v - 1] > u + 1) {
            distances[v - 1] = u + 1
            queue.add(Pair(v - 1, u + 1))
        }
    }

    println(distances[k])
}
