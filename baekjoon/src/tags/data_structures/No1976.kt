package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1976
 */
private lateinit var parents: IntArray
private lateinit var graph: Array<IntArray>

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    setParents(n)
    val cities = readln().split(" ").map { it.toInt() }.toIntArray()
    if (areConnected(m, cities)) {
        println("YES")
    } else {
        println("NO")
    }
}

private fun setParents(n: Int) {
    parents = IntArray(n + 1) { it }
    for (i in graph.indices) {
        for (j in i + 1 until n) {
            if (graph[i][j] == 1) {
                union(i + 1, j + 1)
            }
        }
    }
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)
    parents[py] = px
}

private fun find(n: Int): Int {
    if (parents[n] == n) {
        return n
    }
    parents[n] = find(parents[n])
    return parents[n]
}

private fun areConnected(m: Int, cities: IntArray): Boolean {
    val parent = find(cities[0])
    return (1 until m).all { i -> parent == find(cities[i]) }
}
