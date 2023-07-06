package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10971
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: BooleanArray
private lateinit var order: IntArray
private var n = 0
private var cost = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = BooleanArray(n)
    order = IntArray(n)

    permutation(0)

    println(cost)
}

private fun permutation(index: Int) {
    if (index == n) {
        cost = cost.coerceAtMost(getCost())
        return
    }
    for (i in 0 until n) {
        if (!isVisited[i]) {
            order[index] = i
            isVisited[i] = true
            permutation(index + 1)
            isVisited[i] = false
        }
    }
}

private fun getCost() =
    if ((0 until n).any { i -> graph[order[i % n]][order[(i + 1) % n]] == 0 }) {
        Int.MAX_VALUE
    } else {
        (0 until n).sumOf { i -> graph[order[i % n]][order[(i + 1) % n]] }
    }
