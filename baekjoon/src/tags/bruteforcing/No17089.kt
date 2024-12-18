package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17089
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph(n, m)

    var min = Int.MAX_VALUE
    for (a in 1..n - 2) {
        for (b in a + 1 until n) {
            if (graph[a].contains(b)) {
                for (c in b + 1..n) {
                    if (graph[b].contains(c) && graph[c].contains(a)) {
                        val friends = listOf(a, b, c)
                        val count = friends.sumOf { graph[it].count { f -> f !in friends } }
                        min = min.coerceAtMost(count)
                    }
                }
            }
        }
    }

    if (min == Int.MAX_VALUE) {
        min = -1
    }
    println(min)
}

private fun getGraph(n: Int, m: Int): Array<MutableSet<Int>> {
    val graph = Array(n + 1) { mutableSetOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}
