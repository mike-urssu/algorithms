package tags.implementation

/**
 * https://www.acmicpc.net/problem/10709
 */
fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val graph = Array(h) { readln().toCharArray() }
    val times = getTimes(h, w, graph)
    times.forEach { println(it.joinToString(" ")) }
}

private fun getTimes(h: Int, w: Int, graph: Array<CharArray>): Array<IntArray> {
    val times = Array(h) { IntArray(w) { -1 } }
    (0 until h).forEach { i ->
        (0 until w).forEach { j ->
            if (graph[i][j] == 'c') {
                times[i][j] = 0
            }
        }
    }
    (0 until h).forEach { i ->
        val firstIndex = graph[i].indexOf('c')
        if (firstIndex != -1) {
            (firstIndex + 1 until w).forEach { j ->
                if (graph[i][j] == '.') {
                    times[i][j] = if (graph[i][j - 1] == 'c') {
                        1
                    } else {
                        times[i][j - 1] + 1
                    }
                }
            }
        }
    }
    return times
}
