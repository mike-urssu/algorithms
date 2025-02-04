package tags.dp

/**
 * https://www.acmicpc.net/problem/8394
 */
fun main() {
    val n = readln().toInt()
    val counts = intArrayOf(0, 1, 2, 3)
    if (n > 3) {
        (4..n).forEach { i ->
            counts[i % 4] = (counts[(i + 2) % 4] * 2 + counts[(i + 1) % 4]) % 10
        }
    }
    println(counts[n % 4])
}
