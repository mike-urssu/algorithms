package tags.bfs

/**
 * https://www.acmicpc.net/problem/1389
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var relationship: Array<MutableList<Int>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    relationship = Array(n + 1) { mutableListOf() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        relationship[a].add(b)
        relationship[b].add(a)
    }

    val kevinBacon = IntArray(n + 1) { src -> kevinBacon(n, src) }
    val min = (1..n).minOf { kevinBacon[it] }
    println(kevinBacon.indexOf(min))
}

private fun kevinBacon(n: Int, src: Int) =
    (1..n).sumOf { i -> bfs(n, src, i) }

private fun bfs(n: Int, src: Int, dst: Int): Int {
    val isVisited = BooleanArray(n + 1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    isVisited[src] = true
    queue.add(Pair(src, 0))
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val node = p.first
        val distance = p.second
        if (node == dst) {
            return distance
        }

        for (i in relationship[node]) {
            if (!isVisited[i]) {
                isVisited[i] = true
                queue.add(Pair(i, distance + 1))
            }
        }
    }
    return 0
}
