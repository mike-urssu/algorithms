package tags.bipartite_matching

/**
 * https://www.acmicpc.net/problem/11375
 */
private lateinit var graph: Array<List<Int>>
private lateinit var arrayA: IntArray
private lateinit var arrayB: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n)
    arrayA = IntArray(n + 1)
    arrayB = IntArray(m + 1)

    var matches = 0
    (1..n).forEach { a ->
        isVisited = BooleanArray(n + 1)
        if (bipartiteMatch(a)) {
            matches++
        }
    }
    println(matches)
}

private fun getGraph(n: Int): Array<List<Int>> {
    val graph = Array(n + 1) { listOf<Int>() }
    (1..n).forEach { i ->
        graph[i] = readln().split(" ").map { it.toInt() }.drop(1)
    }
    return graph
}

private fun bipartiteMatch(a: Int): Boolean {
    isVisited[a] = true
    graph[a].forEach { b ->
        if (arrayB[b] == 0 || (!isVisited[arrayB[b]] && bipartiteMatch(arrayB[b]))) {
            arrayA[a] = b
            arrayB[b] = a
            return true
        }
    }
    return false
}
