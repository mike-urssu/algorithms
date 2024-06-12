package tags.dp

/**
 * https://www.acmicpc.net/problem/14495
 */
fun main() {
    val fibonacci = LongArray(117)
    (1..3).forEach { i -> fibonacci[i] = 1 }
    (4..116).forEach { i -> fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 3] }

    val n = readln().toInt()
    println(fibonacci[n])
}
