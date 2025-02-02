package tags.mst

/**
 * https://www.acmicpc.net/problem/14621
 */
import java.util.PriorityQueue

private lateinit var parents: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val genders = CharArray(n + 1).apply {
        readln().split(" ").map { it[0] }.toCharArray().copyInto(this, 1)
    }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    repeat(m) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }
        queue.add(Triple(u, v, d))
    }
    parents = IntArray(n + 1) { it }

    var distance = 0
    while (queue.isNotEmpty()) {
        val (v, u, d) = queue.poll()
        if (genders[v] != genders[u]) {
            if (find(v) != find(u)) {
                union(v, u)
                distance += d
            }
        }
    }

    val parent = find(1)
    if ((1..n).any { find(it) != parent }) {
        distance = -1
    }
    println(distance)
}

private fun union(v: Int, u: Int) {
    val parentV = find(v)
    val parentU = find(u)
    parents[parentV] = parentU
}

private fun find(n: Int): Int {
    if (n != parents[n]) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
