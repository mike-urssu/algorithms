package tags.math

/**
 * https://www.acmicpc.net/problem/15624
 */
fun main() {
    val fibonacci = fibonacci()
    val n = readln().toInt()
    println(fibonacci[n])
}

private fun fibonacci(): IntArray {
    val fibonacci = IntArray(1_000_001)
    fibonacci[1] = 1
    fibonacci[2] = 1
    (3..1_000_000).forEach { i -> fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1_000_000_007 }
    return fibonacci
}
