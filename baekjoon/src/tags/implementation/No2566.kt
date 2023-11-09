package tags.implementation

/**
 * https://www.acmicpc.net/problem/2566
 */
fun main() {
    val graph = Array(9) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val max = graph.maxOf { it.max() }
    val row = graph.indexOfFirst { it.contains(max) }
    val col = graph[row].indexOf(max)

    println(max)
    println("${row + 1} ${col + 1}")
}
