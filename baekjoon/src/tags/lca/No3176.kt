package tags.lca

/**
 * https://www.acmicpc.net/problem/3176
 */
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var depths: IntArray
private lateinit var parents: Array<IntArray>
private lateinit var minDistances: Array<IntArray>
private lateinit var maxDistances: Array<IntArray>

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    depths = IntArray(n + 1)
    parents = Array(n + 1) { IntArray(17) }
    minDistances = Array(n + 1) { IntArray(17) }
    maxDistances = Array(n + 1) { IntArray(17) }

    init(0, 1, 0, 0)

    val k = readln().toInt()
    repeat(k) {
        val (d, e) = readln().split(" ").map { it.toInt() }.sortedByDescending { depths[it] }
        val (min, max) = lca(d, e)
        println("$min $max")
    }
}

private fun getGraph(n: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }
    return graph
}

private fun init(parentNode: Int, node: Int, depth: Int, distance: Int) {
    depths[node] = depth
    parents[node][0] = parentNode
    minDistances[node][0] = distance
    maxDistances[node][0] = distance

    (1..16).forEach { j ->
        if (parents[parents[node][j - 1]][j - 1] != 0) {
            parents[node][j] = parents[parents[node][j - 1]][j - 1]
            minDistances[node][j] = minDistances[node][j - 1].coerceAtMost(minDistances[parents[node][j - 1]][j - 1])
            maxDistances[node][j] = maxDistances[node][j - 1].coerceAtLeast(maxDistances[parents[node][j - 1]][j - 1])
        }
    }

    graph[node].forEach { (childNode, d) ->
        if (parentNode != childNode) {
            init(node, childNode, depth + 1, d)
        }
    }
}

private fun lca(d: Int, e: Int): Pair<Int, Int> {
    var _d = d
    var _e = e
    var min = 1_000_001
    var max = -1

    if (depths[_d] != depths[_e]) {
        (16 downTo 0).forEach { j ->
            if (depths[_d] - depths[_e] >= 1 shl j) {
                min = min.coerceAtMost(minDistances[_d][j])
                max = max.coerceAtLeast(maxDistances[_d][j])
                _d = parents[_d][j]
            }
        }
    }

    if (_d != _e) {
        (16 downTo 0).forEach { j ->
            if (parents[_d][j] != parents[_e][j]) {
                min = min.coerceAtMost(minOf(minDistances[_d][j], minDistances[_e][j]))
                max = max.coerceAtLeast(maxOf(maxDistances[_d][j], maxDistances[_e][j]))
                _d = parents[_d][j]
                _e = parents[_e][j]
            }
        }
        min = min.coerceAtMost(minOf(minDistances[_d][0], minDistances[_e][0]))
        max = max.coerceAtLeast(maxOf(maxDistances[_d][0], maxDistances[_e][0]))
    }

    return min to max
}
