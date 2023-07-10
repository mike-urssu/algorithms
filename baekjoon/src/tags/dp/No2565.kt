package tags.dp

/**
 * https://www.acmicpc.net/problem/2565
 */
fun main() {
    val n = readln().toInt()
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        lines.add(Pair(from, to))
    }
    lines.sortBy { it.first }

    val dp = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (lines[j].second < lines[i].second) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }

    println(n - dp.max() - 1)
}
