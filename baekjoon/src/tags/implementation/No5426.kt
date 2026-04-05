package tags.implementation

/**
 * https://www.acmicpc.net/problem/5426
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val l = sqrt(s.length.toDouble()).toInt()
        val graph = s.chunked(l).map { it.toCharArray() }.toTypedArray()
        rotateCounterClockwise(l, graph)
        println(graph.joinToString("") { it.joinToString("") })
    }
}

private fun rotateCounterClockwise(l: Int, graph: Array<CharArray>) {
    repeat(l / 2) { k ->
        val memory = graph[k].copyOf()
        (k until l - 1 - k).forEach { j -> graph[k][j] = graph[j][l - 1 - k] }
        (k until l - 1 - k).forEach { i -> graph[i][l - 1 - k] = graph[l - 1 - k][l - 1 - i] }
        (l - 1 - k downTo k + 1).forEach { j -> graph[l - 1 - k][j] = graph[j][k] }
        (l - 1 - k downTo k + 1).forEach { i -> graph[i][k] = memory[l - 1 - i] }
    }
}
