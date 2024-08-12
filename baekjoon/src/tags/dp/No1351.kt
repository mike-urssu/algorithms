package tags.dp

/**
 * https://www.acmicpc.net/problem/1351
 */
private val a = mutableMapOf<Long, Long>()
private var p = 0L
private var q = 0L

fun main() {
    val input = readln().split(" ").map { it.toLong() }
    val n = input[0]
    p = input[1]
    q = input[2]
    println(get(n))
}

private fun get(n: Long): Long {
    if (n == 0L) {
        return 1
    }
    if (!a.contains(n)) {
        a[n] = get(n / p) + get(n / q)
    }
    return a[n]!!
}
