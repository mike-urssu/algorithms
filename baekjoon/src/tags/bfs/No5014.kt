package tags.bfs

/**
 * https://www.acmicpc.net/problem/5014
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (f, s, g, u, d) = readln().split(" ").map { it.toInt() }
    var button = -1
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = BooleanArray(f + 1)

    isVisited[0] = true
    isVisited[s] = true
    queue.add(Pair(s, 0))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val n = p.first
        val count = p.second

        if (n == g) {
            button = count
            break
        }

        if (isInBoundary(f, n + u) && !isVisited[n + u]) {
            isVisited[n + u] = true
            queue.add(Pair(n + u, count + 1))
        }
        if (isInBoundary(f, n - d) && !isVisited[n - d]) {
            isVisited[n - d] = true
            queue.add(Pair(n - d, count + 1))
        }
    }

    if (button == -1) {
        println("use the stairs")
    } else {
        println(button)
    }
}

private fun isInBoundary(f: Int, n: Int) = n in 1..f
