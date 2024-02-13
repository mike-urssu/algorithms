package tags.mst

/**
 * https://www.acmicpc.net/problem/1647
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var parents: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val paths = Array(m) {
        val (src, dst, cost) = reader.readLine().split(" ").map { it.toInt() }
        Triple(src, dst, cost)
    }
    println(getMinimumCost(n, paths))
}

private fun getMinimumCost(n: Int, paths: Array<Triple<Int, Int, Int>>): Int {
    parents = IntArray(n + 1) { it }
    var cost = 0
    var maxCost = 0

    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    queue.addAll(paths)
    while (queue.isNotEmpty()) {
        val (src, dst, c) = queue.poll()
        if (union(src, dst)) {
            cost += c
            maxCost = maxCost.coerceAtLeast(c)
        }
    }

    return cost - maxCost
}

private fun union(a: Int, b: Int): Boolean {
    val parentA = find(a)
    val parentB = find(b)

    return if (parentA == parentB) {
        false
    } else {
        if (parentA < parentB) {
            parents[parentB] = parentA
        } else {
            parents[parentA] = parentB
        }
        true
    }
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
