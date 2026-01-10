package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/7511
 */
private val reader = System.`in`.bufferedReader()
private lateinit var parents: IntArray

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        val n = reader.readLine().toInt()
        parents = IntArray(n) { it }
        val k = reader.readLine().toInt()
        repeat(k) {
            val (a, b) = reader.readLine().split(" ").map { it.toInt() }
            union(a, b)
        }

        val result = StringBuilder("Scenario ${it + 1}:\n")
        val m = reader.readLine().toInt()
        repeat(m) {
            val (u, v) = reader.readLine().split(" ").map { it.toInt() }
            if (find(u) == find(v)) {
                result.append("1\n")
            } else {
                result.append("0\n")
            }
        }
        println(result)
    }
}

private fun find(n: Int): Int {
    if (n == parents[n]) {
        return n
    }
    return find(parents[n])
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}
