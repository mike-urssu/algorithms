package tags.bfs

/**
 * https://www.acmicpc.net/problem/6118
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val distances = IntArray(n + 1)
    val queue: Queue<Int> = LinkedList()
    val isVisited = BooleanArray(n + 1)
    queue.add(1)
    isVisited[1] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        graph[p].forEach { node ->
            if (!isVisited[node]) {
                distances[node] = distances[p] + 1
                queue.add(node)
                isVisited[node] = true
            }
        }
    }

    val max = distances.max()
    val index = distances.indexOf(max)
    println("$index ${distances[index]} ${distances.count { it == max }}")
}
