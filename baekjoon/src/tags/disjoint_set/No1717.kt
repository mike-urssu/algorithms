package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/1717
 */
private lateinit var parents: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    parents = IntArray(n + 1) { it }
    repeat(m) {
        val (k, a, b) = readln().split(" ").map { it.toInt() }
        if (k == 0) {
            union(a, b)
        } else {
            if (find(a) == find(b)) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    if (parentA >= parentB) {
        parents[parentA] = parentB
    } else {
        parents[parentB] = parentA
    }
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
