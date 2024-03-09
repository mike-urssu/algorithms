package tags.lca

/**
 * https://www.acmicpc.net/problem/11437
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var depths: IntArray
private lateinit var parents: Array<IntArray>

private const val MAX_DEPTH = 16

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    depths = IntArray(n + 1)
    parents = Array(n + 1) { IntArray(MAX_DEPTH + 1) }

    init(0, 1, 1)

    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(lca(a, b))
    }
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}

private fun init(parentNode: Int, node: Int, depth: Int) {
    depths[node] = depth

    parents[node][0] = parentNode
    (1..MAX_DEPTH).forEach { j -> parents[node][j] = parents[parents[node][j - 1]][j - 1] }

    graph[node].forEach { childNode ->
        if (parentNode != childNode) {
            init(node, childNode, depth + 1)
        }
    }
}

private fun lca(a: Int, b: Int): Int {
    if (a == 1 || b == 1) {
        return 1
    }

    var (lowerNode, upperNode) = getNodes(a, b)
    if (depths[lowerNode] != depths[upperNode]) {
        for (i in MAX_DEPTH downTo 0) {
            if (depths[lowerNode] <= depths[parents[upperNode][i]]) {
                upperNode = parents[upperNode][i]
            }
        }
    }

    var lca = lowerNode
    if (lowerNode != upperNode) {
        for (i in MAX_DEPTH downTo 0) {
            if (parents[lowerNode][i] != parents[upperNode][i]) {
                lowerNode = parents[lowerNode][i]
                upperNode = parents[upperNode][i]
            }
            lca = parents[lowerNode][i]
        }
    }
    return lca
}

private fun getNodes(a: Int, b: Int) =
    if (depths[a] < depths[b]) {
        a to b
    } else {
        b to a
    }
