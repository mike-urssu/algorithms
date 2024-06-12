package tags.dp

/**
 * https://www.acmicpc.net/problem/2502
 */
fun main() {
    val fibonacci = fibonacci()
    val (d, k) = readln().split(" ").map { it.toInt() }
    val a = fibonacci[d]
    val b = fibonacci[d - 1]
    var n = 1
    val inc: Int
    while (true) {
        if ((k - a * n) % b == 0) {
            inc = (k - a * n) / b
            break
        }
        n++
    }
    println(n)
    println(n + inc)
}

private fun fibonacci(): IntArray {
    val fibonacci = IntArray(31)
    fibonacci[1] = 1
    fibonacci[2] = 1
    (3..30).forEach { i -> fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] }
    return fibonacci
}
