package tags.knapsack

/**
 * https://www.acmicpc.net/problem/14728
 */
fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val problems = Array(n) {
        val (k, s) = readln().split(" ").map { it.toInt() }
        k to s
    }.sortedBy { it.first }

    val knapsack = Array(n + 1) { IntArray(10001) }
    problems.forEachIndexed { i, (k, s) ->
        (0 until k).forEach { j ->
            knapsack[i + 1][j] = knapsack[i + 1][j].coerceAtLeast(knapsack[i][j])
        }
        (k..10000).forEach { j ->
            knapsack[i + 1][j] = knapsack[i][j].coerceAtLeast(knapsack[i][j - k] + s)
        }
    }
    println(knapsack.last()[t])
}
