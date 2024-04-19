package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/2056
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var times: IntArray
private lateinit var prefixSum: IntArray
private lateinit var connections: IntArray
private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val n = readln().toInt()
    times = IntArray(n + 1)
    prefixSum = IntArray(n + 1)
    connections = IntArray(n + 1)
    graph = getGraph(n)

    setMin(n)
    println(prefixSum.max())
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1..n) {
        val numbers = readln().split(" ").map { it.toInt() }
        prefixSum[i] = numbers[0]
        times[i] = numbers[0]
        for (j in 0 until numbers[1]) {
            graph[numbers[2 + j]].add(i)
            connections[i]++
        }
    }
    return graph
}

private fun setMin(n: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.addAll((1..n).filter { connections[it] == 0 })

    while (queue.isNotEmpty()) {
        val src = queue.poll()
        graph[src].forEach { dst ->
            prefixSum[dst] = prefixSum[dst].coerceAtLeast(prefixSum[src] + times[dst])
            connections[dst]--
            if (connections[dst] == 0) {
                queue.add(dst)
            }
        }
    }
}
