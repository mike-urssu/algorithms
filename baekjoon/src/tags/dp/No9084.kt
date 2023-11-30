package tags.dp

/**
 * https://www.acmicpc.net/problem/9084
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val coins = readln().split(" ").map { it.toInt() }.toIntArray()
        val m = readln().toInt()
        println(getCount(n, coins, m))
    }
}

private fun getCount(n: Int, coins: IntArray, m: Int): Int {
    val counts = IntArray(m + 1)
    counts[0] = 1
    (0 until n).forEach { i ->
        (coins[i]..m).forEach { j ->
            counts[j] += counts[j - coins[i]]
        }
    }
    return counts.last()
}
