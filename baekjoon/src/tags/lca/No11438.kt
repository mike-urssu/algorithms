package tags.lca

/**
 * https://www.acmicpc.net/problem/11438
 */
private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

private const val MAX_DEPTH = 17
private lateinit var graph: Array<MutableList<Int>>
private lateinit var depths: IntArray
private lateinit var parents: Array<IntArray>

fun main() {
    val n = reader.readLine().toInt()
    graph = getGraph(n)
    depths = IntArray(n + 1)
    parents = Array(n + 1) { IntArray(MAX_DEPTH + 1) }

    init(1, 0, 1)

    val m = reader.readLine().toInt()
    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${lca(a, b)}\n")
    }
    writer.flush()
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}

private fun init(node: Int, parentNode: Int, depth: Int) {
    depths[node] = depth
    parents[node][0] = parentNode

    (1..MAX_DEPTH).forEach { j ->
        parents[node][j] = parents[parents[node][j - 1]][j - 1]
    }

    graph[node].forEach { childNode ->
        if (parentNode != childNode) {
            init(childNode, node, depth + 1)
        }
    }
}

private fun lca(a: Int, b: Int): Int {
    if (a == 1 || b == 1) {
        return 1
    }

    var (upperNode, lowerNode) = getNodes(a, b)
    if (depths[upperNode] != depths[lowerNode]) {
        for (i in MAX_DEPTH downTo 0) {
            if (depths[parents[lowerNode][i]] >= depths[upperNode]) {
                lowerNode = parents[lowerNode][i]
            }
        }
    }

    var lca = upperNode
    if (upperNode != lowerNode) {
        for (i in MAX_DEPTH downTo 0) {
            if (parents[upperNode][i] != parents[lowerNode][i]) {
                upperNode = parents[upperNode][i]
                lowerNode = parents[lowerNode][i]
            }
            lca = parents[upperNode][i]
        }
    }
    return lca
}

private fun getNodes(a: Int, b: Int) =
    if (depths[a] < depths[b]) {
        intArrayOf(a, b)
    } else {
        intArrayOf(b, a)
    }
