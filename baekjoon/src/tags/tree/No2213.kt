package tags.tree

/**
 * https://www.acmicpc.net/problem/2213
 */
private lateinit var weights: IntArray
private lateinit var graph: Array<MutableList<Int>>
private lateinit var sum: Array<IntArray>
private lateinit var paths: MutableList<Int>
private lateinit var isVisited: BooleanArray

fun main() {
    val n = readln().toInt()
    weights = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    graph = getGraph(n)

    setSum(n)

    setPaths(n)
    println(paths.sumOf { weights[it] })
    println(paths.sorted().joinToString(" "))
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun setSum(n: Int) {
    sum = Array(n + 1) { IntArray(2) }
    isVisited = BooleanArray(n + 1)
    dfs(1)
}

private fun dfs(src: Int) {
    sum[src][0] = 0
    sum[src][1] = weights[src]
    isVisited[src] = true

    graph[src].forEach { node ->
        if (!isVisited[node]) {
            dfs(node)
            sum[src][0] += maxOf(sum[node][0], sum[node][1])
            sum[src][1] += sum[node][0]
        }
    }
}

private fun setPaths(n: Int) {
    paths = mutableListOf()
    isVisited = BooleanArray(n + 1)

    val isContaining = sum[1][0] < sum[1][1]
    setPaths(1, isContaining)
}

private fun setPaths(src: Int, isContaining: Boolean) {
    isVisited[src] = true

    if (isContaining) {
        paths.add(src)
        graph[src].forEach { node ->
            if (!isVisited[node]) {
                setPaths(node, false)
            }
        }
    } else {
        graph[src].forEach { node ->
            if (!isVisited[node]) {
                setPaths(node, sum[node][0] < sum[node][1])
            }
        }
    }
}
