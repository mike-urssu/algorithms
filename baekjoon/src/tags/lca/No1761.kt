package tags.lca

/**
 * https://www.acmicpc.net/problem/1761
 */
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var depths: IntArray
private lateinit var parents: Array<IntArray>
private lateinit var distances: Array<IntArray>

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    depths = IntArray(n + 1)
    parents = Array(n + 1) { IntArray(17) }
    distances = Array(n + 1) { IntArray(17) }

    setParentsAndDistances(0, 1, 0, 0)

    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }.sortedByDescending { depths[it] }
        println(lca(a, b))
    }
}

private fun getGraph(n: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (a, b, d) = readln().split(" ").map { it.toInt() }
        graph[a].add(b to d)
        graph[b].add(a to d)
    }
    return graph
}

private fun setParentsAndDistances(parentNode: Int, node: Int, depth: Int, distance: Int) {
    depths[node] = depth

    parents[node][0] = parentNode
    distances[node][0] = distance

    (1..16).forEach { j ->
        if (parents[parents[node][j - 1]][j - 1] != 0) {
            parents[node][j] = parents[parents[node][j - 1]][j - 1]
            distances[node][j] = distances[node][j - 1] + distances[parents[node][j - 1]][j - 1]
        }
    }

    graph[node].forEach { (childNode, d) ->
        if (parentNode != childNode) {
            setParentsAndDistances(node, childNode, depth + 1, d)
        }
    }
}

private fun lca(a: Int, b: Int): Int {
    var distance = 0
    var _a = a
    var _b = b

    if (depths[_a] != depths[_b]) {
        var diff = depths[_a] - depths[_b]
        var j = 0
        while (diff > 0) {
            if (diff % 2 == 1) {
                distance += distances[_a][j]
                _a = parents[_a][j]
            }
            diff = diff shr 1
            j++
        }
    }

    if (_a != _b) {
        (16 downTo 0).forEach { j ->
            if (parents[_a][j] != 0 && parents[_a][j] != parents[_b][j]) {
                distance += distances[_a][j] + distances[_b][j]
                _a = parents[_a][j]
                _b = parents[_b][j]
            }
        }
        distance += distances[_a][0] + distances[_b][0]
    }
    return distance
}
