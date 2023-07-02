package tags.dp

/**
 * https://www.acmicpc.net/problem/11055
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    val dp = IntArray(numbers.size) { i -> numbers[i] }
    for (i in numbers.indices) {
        for (j in i - 1 downTo 0) {
            if (numbers[i] > numbers[j]) {
                dp[i] = dp[i].coerceAtLeast(numbers[i] + dp[j])
            }
        }
    }
    println(dp.max())
}
