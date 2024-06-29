package tags.implementation

/**
 * https://www.acmicpc.net/problem/10163
 */
fun main() {
    val n = readln().toInt()
    val graph = Array(1001) { IntArray(1001) }
    repeat(n) { k ->
        val (a, b, h, w) = readln().split(" ").map { it.toInt() }
        (a until a + h).forEach { i ->
            (b until b + w).forEach { j ->
                graph[i][j] = k + 1
            }
        }
    }

    val counts = IntArray(n + 1).apply {
        (0..1000).forEach { i ->
            (0..1000).forEach { j ->
                this[graph[i][j]]++
            }
        }
    }
    (1..n).forEach { println(counts[it]) }
}
