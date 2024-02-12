package tags.dp

/**
 * https://www.acmicpc.net/problem/2098
 */
private var n = 0
private lateinit var costs: Array<IntArray>
private lateinit var dp: Array<IntArray>

private const val MAX = 1_000_000_000

fun main() {
    n = readln().toInt()
    costs = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println(getMinimumCost())
}

private fun getMinimumCost(): Int {
    dp = Array(n) { IntArray(1 shl n) { -1 } }
    return tsp(0, 1)
}

private fun tsp(city: Int, visitedCities: Int): Int {
    if (visitedAllCities(visitedCities)) {
        return if (costs[city][0] == 0) {
            MAX
        } else {
            costs[city][0]
        }
    }

    if (dp[city][visitedCities] != -1) {
        return dp[city][visitedCities]
    }

    dp[city][visitedCities] = MAX
    for (nextCity in 0 until n) {
        if (!isVisited(visitedCities, nextCity) && costs[city][nextCity] != 0) {
            val cost = costs[city][nextCity] + tsp(nextCity, visitCity(visitedCities, nextCity))
            dp[city][visitedCities] = dp[city][visitedCities].coerceAtMost(cost)
        }
    }

    return dp[city][visitedCities]
}

private fun visitedAllCities(visitedCities: Int) =
    visitedCities == (1 shl n) - 1

private fun isVisited(visitedCities: Int, nextCity: Int) =
    visitedCities.and(1 shl nextCity) != 0

private fun visitCity(visitedCities: Int, nextCity: Int) =
    visitedCities.or(1 shl nextCity)
