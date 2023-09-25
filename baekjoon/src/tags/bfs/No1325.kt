package tags.bfs

/**
 * https://www.acmicpc.net/problem/1325
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val computers = getComputers(n)
    val max = computers.max()
    (1..n).forEach { i ->
        if (computers[i] == max) {
            print("$i ")
        }
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[b].add(a)
    }
    return graph
}

private fun getComputers(n: Int): IntArray {
    val computers = IntArray(n + 1)

    for (i in 1..n) {
        val isVisited = BooleanArray(n + 1)
        val queue: Queue<Int> = LinkedList()

        isVisited[i] = true
        queue.add(i)
        while (queue.isNotEmpty()) {
            val c = queue.poll()

            for (j in graph[c]) {
                if (!isVisited[j]) {
                    computers[i]++
                    isVisited[j] = true
                    queue.add(j)
                }
            }
        }
    }
    return computers
}
