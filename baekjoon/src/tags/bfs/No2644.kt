package tags.bfs

/**
 * https://www.acmicpc.net/problem/2644
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var connections: Array<MutableList<Int>>

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    connections = getConnections(n, m)
    println(bfs(n, a, b))
}

private fun getConnections(n: Int, m: Int): Array<MutableList<Int>> {
    val connections = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        connections[x].add(y)
        connections[y].add(x)
    }
    return connections
}

private fun bfs(n: Int, a: Int, b: Int): Int {
    val isVisited = BooleanArray(n + 1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[a] = true
    queue.add(Pair(a, 0))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        if (b == p.first) {
            return p.second
        }
        for (c in connections[p.first]) {
            if (!isVisited[c]) {
                isVisited[c] = true
                queue.add(Pair(c, p.second + 1))
            }
        }
    }

    return -1
}
