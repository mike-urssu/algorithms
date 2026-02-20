package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/14675
 */
private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)

    val q = readln().toInt()
    repeat(q) {
        val (t, k) = readln().split(" ").map { it.toInt() }
        if (t == 1) {
            if (graph[k].size == 1) {
                println("no")
            } else {
                println("yes")
            }
        } else {
            println("yes")
        }
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
