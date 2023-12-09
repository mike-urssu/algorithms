package tags.mst

/**
 * https://www.acmicpc.net/problem/9372
 */
private lateinit var parents: IntArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        parents = IntArray(n + 1) { it }
        var planes = 0
        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            if (find(a) != find(b)) {
                union(a, b)
                planes++
            }
        }
        println(planes)
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
