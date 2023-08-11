package tags.bfs

/**
 * https://www.acmicpc.net/problem/2606
 */
private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    parents = IntArray(n + 1) { it }
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        union(x, y)
    }
    val count = (2..n).count { find(it) == parents[1] }
    println(count)
}

private fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)
    if (px <= py) {
        parents[py] = px
    } else {
        parents[px] = py
    }
}

private fun find(n: Int): Int {
    if (parents[n] == n) {
        return n
    }
    parents[n] = find(parents[n])
    return parents[n]
}
