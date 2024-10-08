package tags.recursion

/**
 * https://www.acmicpc.net/problem/16974
 */
private val lengths = mutableMapOf<Long, Long>()
private val patties = mutableMapOf<Long, Long>()

fun main() {
    init()
    val (n, x) = readln().split(" ").map { it.toLong() }
    println(getPatty(n, 1, x))
}

private fun init() {
    lengths[0] = 1
    patties[0] = 1
    (1L..50).forEach { i ->
        lengths[i] = lengths[i - 1]!! * 2 + 3
        patties[i] = patties[i - 1]!! * 2 + 1
    }
}

private fun getPatty(n: Long, from: Long, to: Long): Long {
    if (n == 1L) {
        return (from..to).count { it in 2..4 }.toLong()
    }

    val mid = (1 + lengths[n]!!) shr 1

    val left = if (mid <= to) {
        patties[n - 1]!!
    } else {
        getPatty(n - 1, from, to - 1)
    }

    val center = if (mid <= to) {
        1
    } else {
        0
    }

    val right = if (mid < to) {
        getPatty(n - 1, 1, to - mid)
    } else {
        0
    }

    return left + center + right
}
