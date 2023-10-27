package tags.dp

/**
 * https://www.acmicpc.net/problem/13398
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    if (n == 1) {
        println(numbers[0])
    } else {
        println(getMax(n, numbers))
    }
}

private fun getMax(n: Int, numbers: IntArray): Int {
    val dp = Array(2) { IntArray(n) }
    dp[0][0] = numbers[0]
    for (i in 1 until n) {
        dp[0][i] = maxOf(dp[0][i - 1] + numbers[i], numbers[i])
        dp[1][i] = maxOf(dp[0][i - 1], dp[1][i - 1] + numbers[i])
    }
    return (1 until n).maxOf { i -> maxOf(dp[0][i], dp[1][i]) }
}
