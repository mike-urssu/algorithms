package tags.dp

/**
 * https://www.acmicpc.net/problem/9711
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (p, q) = readln().split(" ").map { it.toInt() }
        println("Case #${it + 1}: ${fibonacci(p, q)}")
    }
}

private fun fibonacci(p: Int, q: Int): Long {
    if (q == 1) {
        return 0
    }
    if (p < 3) {
        return 1
    }

    val f = LongArray(3)
    f[1] = 1
    f[2] = 1
    (3..p).forEach { i -> f[i % 3] = (f[(i - 2) % 3] + f[(i - 1) % 3]) % q }
    return f[p % 3]
}
