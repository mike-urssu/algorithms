package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/1948
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<Array<MutableList<Pair<Int, Int>>>>
private lateinit var indegree: IntArray
private lateinit var times: IntArray

fun main() {
    n = readln().toInt()
    m = readln().toInt()
    graph = getGraph(n, m)
    val (root, last) = readln().split(" ").map { it.toInt() }

    times = topologySort(root)
    println(times.max())
    println(countPaths(last))
}

private fun getGraph(n: Int, m: Int): Array<Array<MutableList<Pair<Int, Int>>>> {
    val graph = Array(2) { Array(n + 1) { mutableListOf<Pair<Int, Int>>() } }
    indegree = IntArray(n + 1)
    repeat(m) {
        val (src, dst, t) = readln().split(" ").map { it.toInt() }
        graph[0][src].add(dst to t)
        graph[1][dst].add(src to t)
        indegree[dst]++
    }
    return graph
}

private fun topologySort(root: Int): IntArray {
    val times = IntArray(n + 1)
    val queue: Queue<Int> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val src = queue.poll()
        graph[0][src].forEach { (dst, t) ->
            times[dst] = times[dst].coerceAtLeast(times[src] + t)
            if (--indegree[dst] == 0) {
                queue.add(dst)
            }
        }
    }
    return times
}

private fun countPaths(last: Int): Int {
    var paths = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = BooleanArray(n + 1)
    queue.add(last to 0)
    isVisited[last] = true

    while (queue.isNotEmpty()) {
        val (dst, acc) = queue.poll()
        graph[1][dst].forEach { (src, t) ->
            if (times[src] + t + acc == times[last]) {
                if (!isVisited[src]) {
                    isVisited[src] = true
                    queue.add(src to t + acc)
                }
                paths++
            }
        }
    }
    return paths
}
