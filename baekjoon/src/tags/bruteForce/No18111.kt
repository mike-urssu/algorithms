package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/18111
 */
fun main() {
    val (n, _, b) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var height = 0
    var seconds = Int.MAX_VALUE
    for (h in 0..256) {
        val bricksToAdd = getBricksToAdd(graph, h)
        val bricksToRemove = getBricksToRemove(graph, h)

        if (bricksToAdd <= b + bricksToRemove) {
            val s = bricksToAdd + bricksToRemove * 2
            if (s <= seconds) {
                height = height.coerceAtLeast(h)
                seconds = s
            }
        }
    }

    println("$seconds $height")
}

private fun getBricksToAdd(graph: Array<IntArray>, height: Int): Int {
    var bricks = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            bricks += maxOf(height - graph[i][j], 0)
        }
    }
    return bricks
}

private fun getBricksToRemove(graph: Array<IntArray>, height: Int): Int {
    var bricks = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            bricks += maxOf(graph[i][j] - height, 0)
        }
    }
    return bricks
}
