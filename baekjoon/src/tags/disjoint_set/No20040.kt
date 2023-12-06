package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/20040
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var parents: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    parents = IntArray(n) { it }
    val pairs = Array(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        Pair(a, b)
    }
    println(getCycle(pairs))
}

private fun getCycle(pairs: Array<Pair<Int, Int>>): Int {
    for ((i, pair) in pairs.withIndex()) {
        val (a, b) = pair
        if (union(a, b)) {
            return i + 1
        }
    }
    return 0
}

private fun union(a: Int, b: Int): Boolean {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentB] = parentA
    return parentA == parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
