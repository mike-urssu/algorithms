package tags.dp

/**
 * https://www.acmicpc.net/problem/14606
 */
fun main() {
    val n = readln().toInt()
    println(divide(n))
}

private val dp = IntArray(11)

private fun divide(h: Int): Int {
    if (h == 1) {
        return 0
    }

    if (dp[h] != 0) {
        return dp[h]
    }

    val a = h / 2
    val b = h - a
    val sum = a * b + divide(a) + divide(b)
    dp[h] = sum

    return dp[h]
}
