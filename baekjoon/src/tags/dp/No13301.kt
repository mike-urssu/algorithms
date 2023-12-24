package tags.dp

/**
 * https://www.acmicpc.net/problem/13301
 */
fun main() {
    val n = readln().toInt()
    println(fibonacci()[n])
}

private fun fibonacci(): LongArray {
    val fibonacci = LongArray(81)
    fibonacci[1] = 4
    fibonacci[2] = 6
    (3..80).forEach { i -> fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1] }
    return fibonacci
}
