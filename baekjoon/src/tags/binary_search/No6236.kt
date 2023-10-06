package tags.binary_search

/**
 * https://www.acmicpc.net/problem/6236
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val costs = IntArray(n) { readln().toInt() }
    println(getMoney(costs, m))
}

private fun getMoney(costs: IntArray, m: Int): Int {
    var low = 0
    var high = Int.MAX_VALUE
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (costs.any { it > mid }) {
            low = mid
        }
        if (isValid(costs, m, mid)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isValid(costs: IntArray, m: Int, k: Int): Boolean {
    if (costs.any { it > k }) {
        return false
    }

    var money = k
    var count = 1
    for (cost in costs) {
        if (money < cost) {
            money = k
            count++
        }
        money -= cost
    }
    return count <= m
}
