package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/12101
 */
private val set = sortedSetOf<String>()
private val numbers = intArrayOf(1, 2, 3)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    numbers.forEach { makeN(n, it.toString(), it) }
    val v = if (set.size < k) {
        -1
    } else {
        set.toList()[k - 1]
    }
    println(v)
}

private fun makeN(n: Int, s: String, v: Int) {
    if (n == v) {
        set.add(s)
        return
    }

    numbers.forEach {
        val sum = v + it
        if (sum <= n) {
            makeN(n, "$s+$it", sum)
        }
    }
}
