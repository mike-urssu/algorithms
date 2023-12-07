package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/1976
 */
private lateinit var graph: Array<IntArray>
private lateinit var cities: IntArray
private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    cities = readln().split(" ").map { it.toInt() }.toIntArray()

    parents = IntArray(n + 1) { it }
    setParents(n)

    if (isAllConnected(m, cities)) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun setParents(n: Int) {
    for (j in n - 1 downTo 0) {
        for (i in 0..j) {
            if (graph[i][j] == 1) {
                union(i + 1, j + 1)
            }
        }
    }
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

private fun isAllConnected(m: Int, cities: IntArray): Boolean {
    if (m == 0) {
        return true
    }
    val p = find(parents[cities[0]])
    return cities.all { p == find(parents[it]) }
}
