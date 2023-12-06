package tags.dp

/**
 * https://www.acmicpc.net/problem/2302
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val vipSeats = getVipSeats(n, m)
    println(getCombination(m, vipSeats))
}

private fun getVipSeats(n: Int, m: Int) =
    IntArray(m + 2).apply {
        (1..m).forEach { i -> this[i] = readln().toInt() }
        this[m + 1] = n + 1
    }

private fun getCombination(m: Int, vipSeats: IntArray): Int {
    val dp = getDp()
    val group = getGroup(m, vipSeats)
    return group.fold(1) { acc, i -> acc * dp[i] }
}

private fun getGroup(m: Int, vipSeats: IntArray) =
    (1 until m + 2).map { i -> vipSeats[i] - vipSeats[i - 1] - 1 }

private fun getDp(): IntArray {
    val dp = IntArray(41)
    dp[0] = 1
    dp[1] = 1
    (2..40).forEach { i -> dp[i] = dp[i - 2] + dp[i - 1] }
    return dp
}
