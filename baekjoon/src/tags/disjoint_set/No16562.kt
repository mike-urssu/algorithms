package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/16562
 */
private lateinit var parents: IntArray
private lateinit var prices: IntArray

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    parents = IntArray(n + 1) { it }
    prices = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        union(a, b)
    }

    val isVisited = BooleanArray(n + 1)
    var sum = 0
    (1..n).forEach { i ->
        val parent = find(i)
        if (!isVisited[parent]) {
            sum += prices[parent]
            isVisited[parent] = true
        }
    }

    if (sum > k) {
        println("Oh no")
    } else {
        println(sum)
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)

    if (prices[parentA] >= prices[parentB]) {
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
