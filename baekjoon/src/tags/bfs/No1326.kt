package tags.bfs

/**
 * https://www.acmicpc.net/problem/1326
 */
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val tokens = StringTokenizer(readln())
    val numbers = IntArray(n) { tokens.nextToken().toInt() }
    val (a, b) = readln().split(" ").map { it.toInt() - 1 }

    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }
    queue.add(a to 0)
    val isVisited = BooleanArray(n)
    isVisited[a] = true

    while (queue.isNotEmpty()) {
        val (p, c) = queue.poll()
        if (p == b) {
            println(c)
            return
        }

        val leap = numbers[p]
        (p - leap downTo 0 step leap).forEach { i ->
            if (!isVisited[i]) {
                isVisited[i] = true
                queue.add(i to c + 1)
            }
        }
        (p + leap until n step leap).forEach { i ->
            if (!isVisited[i]) {
                isVisited[i] = true
                queue.add(i to c + 1)
            }
        }
    }

    println(-1)
}
