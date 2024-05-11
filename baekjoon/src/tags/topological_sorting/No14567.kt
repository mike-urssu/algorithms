package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/14567
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val depths = IntArray(n + 1)
    val counts = IntArray(n + 1)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        counts[b]++
    }

    val sources = (1..n).filter { i -> counts[i] == 0 }
    sources.forEach { i -> depths[i] = 1 }

    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>().apply { this.addAll(sources.map { it to 1 }) }
    while (queue.isNotEmpty()) {
        val (node, depth) = queue.poll()
        graph[node].forEach { dst ->
            counts[dst]--
            if (counts[dst] == 0) {
                depths[dst] = depth + 1
                queue.add(dst to depth + 1)
            }
        }
    }

    println((1..n).joinToString(" ") { depths[it].toString() })
}
