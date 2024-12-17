package tags.knapsack

/**
 * https://www.acmicpc.net/problem/1106
 */
fun main() {
    val (c, n) = readln().split(" ").map { it.toInt() }
    val cities = Array(n) {
        val (cost, customer) = readln().split(" ").map { it.toInt() }
        cost to customer
    }

    val knapsack = Array(n + 1) { IntArray(100001) }
    cities.forEachIndexed { i, (cost, customer) ->
        (1 until cost).forEach { j ->
            knapsack[i + 1][j] = knapsack[i][j]
        }
        (cost..100000).forEach { j ->
            knapsack[i + 1][j] = maxOf(knapsack[i][j], knapsack[i + 1][j - cost] + customer)
        }
    }

    val min = (1..100000).first { j -> knapsack[n][j] >= c }
    println(min)
}
