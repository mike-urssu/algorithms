package tags.bfs

/**
 * https://www.acmicpc.net/problem/18352
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val (n, m, k, x) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val dst = bfs(n, x, k)

    if (dst.isEmpty()) {
        println(-1)
    } else {
        dst.sorted().forEach { println(it) }
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
    }
    return graph
}

private fun bfs(n: Int, x: Int, k: Int): MutableList<Int> {
    val dst = mutableListOf<Int>()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = BooleanArray(n + 1)

    queue.add(Pair(x, 0))
    isVisited[x] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val node = p.first
        val count = p.second

        if (count == k) {
            dst.add(node)
            continue
        }

        graph[node].forEach {
            if (!isVisited[it]) {
                isVisited[it] = true
                queue.add(Pair(it, count + 1))
            }
        }
    }

    return dst
}
