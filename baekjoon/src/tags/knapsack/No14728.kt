package tags.knapsack

/**
 * https://www.acmicpc.net/problem/14728
 */
fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val knapsack = Array(n + 1) { IntArray(10001) }
    repeat(n) { i ->
        val (k, s) = readln().split(" ").map { it.toInt() }
        (0 until k).forEach { j ->
            knapsack[i + 1][j] = knapsack[i + 1][j].coerceAtLeast(knapsack[i][j])
        }
        (k..t).forEach { j ->
            knapsack[i + 1][j] = knapsack[i][j].coerceAtLeast(knapsack[i][j - k] + s)
        }
    }
    println(knapsack.last()[t])
}
