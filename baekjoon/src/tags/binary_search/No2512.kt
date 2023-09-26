package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2512
 */
fun main() {
    readln()
    val budgets = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()

    if (budgets.sum() <= m) {
        println(budgets.max())
    } else {
        println(getMaxBudget(budgets, m))
    }
}

private fun getMaxBudget(budgets: IntArray, m: Int): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val sum = budgets.sumOf { minOf(it, mid) }
        if (sum > m) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
