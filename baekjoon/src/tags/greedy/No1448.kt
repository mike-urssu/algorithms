package tags.greedy

/**
 * https://www.acmicpc.net/problem/1448
 */
private val reader = System.`in`.bufferedReader()

fun main() {
    val n = reader.readLine().toInt()
    val numbers = IntArray(n) { reader.readLine().toInt() }.sortedArrayDescending()
    val index = (0 until n - 2).firstOrNull { i -> numbers[i] < numbers[i + 1] + numbers[i + 2] } ?: -1
    val sumOfLength = if (index != -1) {
        numbers[index] + numbers[index + 1] + numbers[index + 2]
    } else {
        -1
    }
    println(sumOfLength)
}
