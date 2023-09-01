package tags.bfs

/**
 * https://www.acmicpc.net/problem/11725
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var parents: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var nodes: Array<MutableList<Int>>

fun main() {
    val n = readln().toInt()
    parents = IntArray(n + 1)
    isVisited = BooleanArray(n + 1)
    nodes = Array(n + 1) { mutableListOf() }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        nodes[a].add(b)
        nodes[b].add(a)
    }

    (1..n).forEach { bfs(it) }
    (2..n).forEach { println(parents[it]) }
}

private fun bfs(node: Int) {
    val queue: Queue<Int> = LinkedList()
    isVisited[node] = true
    queue.add(node)

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (n in nodes[p]) {
            if (!isVisited[n]) {
                parents[n] = p
                isVisited[n] = true
                queue.add(n)
            }
        }
    }
}
