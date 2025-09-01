package tags.string

/**
 * https://www.acmicpc.net/problem/3035
 */
fun main() {
    val (r, c, zr, zc) = readln().split(" ").map { it.toInt() }
    val graph = Array(r) { readln().toCharArray() }

    val newGraph = StringBuilder()
    (0 until r).forEach { i ->
        repeat(zr) {
            (0 until c).forEach { j ->
                repeat(zc) {
                    newGraph.append(graph[i][j])
                }
            }
            newGraph.append("\n")
        }
    }
    println(newGraph)
}
