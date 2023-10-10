package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1939
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    val (src, dst) = readln().split(" ").map { it.toInt() }
    println(getMaxWeights(n, src, dst))
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }
    return graph
}

private fun getMaxWeights(n: Int, src: Int, dst: Int): Int {
    var low = 0
    var high = 1000000001
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (canPass(n, src, dst, mid)) {
            low = mid
        } else {
            high = mid
        }
    }
    return low
}

private fun canPass(n: Int, src: Int, dst: Int, weight: Int): Boolean {
    val isVisited = BooleanArray(n + 1)
    val queue: Queue<Int> = LinkedList()

    isVisited[src] = true
    queue.add(src)

    while (queue.isNotEmpty()) {
        val i = queue.poll()
        if (i == dst) {
            return true
        }

        for ((j, limit) in graph[i]) {
            if (!isVisited[j] && limit >= weight) {
                isVisited[j] = true
                queue.add(j)
            }
        }
    }

    return false
}
