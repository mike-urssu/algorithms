package tags.dp

/**
 * https://www.acmicpc.net/problem/9507
 */
fun main() {
    val fibonacci = fibonacci()

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(fibonacci[n])
    }
}

private fun fibonacci(): LongArray {
    val fibonacci = LongArray(68)
    fibonacci[0] = 1
    fibonacci[1] = 1
    fibonacci[2] = 2
    fibonacci[3] = 4
    (4..67).forEach { i -> fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3] + fibonacci[i - 4] }
    return fibonacci
}
