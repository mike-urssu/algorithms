package tags.mst

/**
 * https://www.acmicpc.net/problem/1922
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    parents = IntArray(n + 1) { it }

    val connections = getConnections(m)
    println(getMinimumCost(connections))
}

private fun getConnections(m: Int): Queue<Triple<Int, Int, Int>> {
    val connections = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        connections.add(Triple(a, b, c))
        connections.add(Triple(b, a, c))
    }
    return connections
}

private fun getMinimumCost(connections: Queue<Triple<Int, Int, Int>>): Int {
    var minimumCost = 0
    while (connections.isNotEmpty()) {
        val (src, dst, cost) = connections.poll()
        if (find(src) != find(dst)) {
            union(src, dst)
            minimumCost += cost
        }
    }
    return minimumCost
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    if (parentA > parentB) {
        parents[parentA] = parentB
    } else {
        parents[parentB] = parentA
    }
}

private fun find(n: Int): Int {
    if (n != parents[n]) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
