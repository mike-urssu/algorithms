package tags.mst

/**
 * https://www.acmicpc.net/problem/6497
 */
private lateinit var parents: IntArray

fun main() {
    while (true) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) {
            break
        }

        val paths = getPaths(n)
        println(getCost(m, paths))
    }
}

private fun getPaths(n: Int): Array<Triple<Int, Int, Int>> {
    val paths = Array(n) {
        val (x, y, z) = readln().split(" ").map { it.toInt() }
        Triple(x, y, z)
    }
    paths.sortWith { it, other -> it.third.compareTo(other.third) }
    return paths
}

private fun getCost(m: Int, paths: Array<Triple<Int, Int, Int>>): Int {
    parents = IntArray(m + 1) { it }

    var cost = 0
    paths.forEach { (src, dst, c) ->
        if (find(src) != find(dst)) {
            union(src, dst)
            cost += c
        }
    }
    return paths.sumOf { it.third } - cost
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
