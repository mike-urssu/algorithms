package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/1034
 */
fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln() }
    val k = readln().toInt()

    val patternCounts = mutableMapOf<String, Int>().apply {
        graph.forEach { this[it] = (this[it] ?: 0) + 1 }
    }
    var max = 0

    patternCounts.forEach { (pattern, count) ->
        val zeroCount = pattern.count { it == '0' }
        if (zeroCount <= k && (k - zeroCount) % 2 == 0) {
            max = maxOf(max, count)
        }
    }
    println(max)
}
