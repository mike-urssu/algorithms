package tags.lis

/**
 * https://www.acmicpc.net/problem/2568
 */
private lateinit var nodes: List<Pair<Int, Int>>
private lateinit var indices: IntArray
private val lis = mutableListOf<Pair<Int, Int>>()

fun main() {
    val n = readln().toInt()
    nodes = Array(n) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        src to dst
    }.sortedWith { it, other -> it.first.compareTo(other.first) }
    indices = IntArray(n)

    lis()

    val removedNodes = mutableListOf<Int>()
    var idx = lis.lastIndex
    (n - 1 downTo 0).forEach { i ->
        if (idx == indices[i]) {
            idx--
        } else {
            removedNodes.add(nodes[i].first)
        }
    }
    println(removedNodes.size)
    removedNodes.reversed().forEach { println(it) }
}

private fun lis() {
    nodes.forEachIndexed { i, node ->
        val (_, dst) = node
        val index = indexOf(dst)
        if (index == lis.size) {
            lis.add(node)
        } else {
            lis[index] = node
        }
        indices[i] = index
    }
}

private fun indexOf(v: Int): Int {
    var low = -1
    var high = lis.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (v <= lis[mid].second) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
