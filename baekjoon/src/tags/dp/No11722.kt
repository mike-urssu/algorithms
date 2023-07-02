package tags.dp

/**
 * https://www.acmicpc.net/problem/11722
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    val dp = IntArray(numbers.size) { 1 }
    for (i in numbers.indices) {
        for (j in 0 until i) {
            if (numbers[i] < numbers[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    println(dp.max())
}
