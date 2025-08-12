package tags.implementation

/**
 * https://www.acmicpc.net/problem/10864
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    (1..n).forEach { i -> println(graph[i].size) }
}
