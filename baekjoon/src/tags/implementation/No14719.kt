package tags.implementation

/**
 * https://www.acmicpc.net/problem/14719
 */
private lateinit var graph: Array<BooleanArray>

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    graph = getGraph(h, w)
    println(getRainwater(h, w))
}

private fun getGraph(h: Int, w: Int): Array<BooleanArray> {
    val graph = Array(h) { BooleanArray(w) }
    val blocks = readln().split(" ").map { it.toInt() }.toIntArray()
    (0 until w).forEach { j ->
        (h - 1 downTo h - blocks[j]).forEach { i ->
            graph[i][j] = true
        }
    }
    return graph
}

private fun getRainwater(h: Int, w: Int) =
    (0 until h).sumOf { height -> getApertures(height, w) }

private fun getApertures(height: Int, w: Int): Int {
    val indices = (0 until w).filter { j -> graph[height][j] }
    return indices.zipWithNext { previousIndex, nextIndex -> nextIndex - previousIndex - 1 }.sum()
}
