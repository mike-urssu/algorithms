package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/2560
 */
fun main() {
    val (a, b, d, n) = readln().split(" ").map { it.toInt() }
    val paramecia = IntArray(n + 1)
    (0 until a).forEach { i -> paramecia[i] = 1 }
    (a until b).forEach { i -> paramecia[i] = (paramecia[i - 1] + paramecia[i - a]) % 1000 }
    (b..n).forEach { i -> paramecia[i] = (paramecia[i - 1] + paramecia[i - a] - paramecia[i - b] + 1000) % 1000 }
    if (n < d) {
        println(paramecia.last())
    } else {
        println((paramecia.last() - paramecia[n - d] + 1000) % 1000)
    }
}
