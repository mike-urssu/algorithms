package tags.bfs

/**
 * https://www.acmicpc.net/problem/11724
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var nodes: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    nodes = Array(n + 1) { mutableListOf() }
    isVisited = BooleanArray(n + 1)
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        nodes[u].add(v)
        nodes[v].add(u)
    }

    println(countConnectedComponents(n))
}

private fun countConnectedComponents(n: Int): Int {
    var count = 0
    for (i in 1..n) {
        if (!isVisited[i]) {
            bfs(i)
            count++
        }
    }
    return count
}

private fun bfs(node: Int) {
    val queue: Queue<Int> = LinkedList()
    nodes[node].forEach { i ->
        queue.add(i)
        isVisited[i] = true
    }

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        nodes[p].forEach { i ->
            if (!isVisited[i]) {
                queue.add(i)
                isVisited[i] = true
            }
        }
    }
}
