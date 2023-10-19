package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15650
 */
private lateinit var combination: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    combination = IntArray(m)

    (1..n).forEach { i ->
        combination(n, m, 0, i)
    }
}

private fun combination(n: Int, r: Int, index: Int, value: Int) {
    combination[index] = value
    if (index == r - 1) {
        println(combination.joinToString(" "))
        return
    }

    (value + 1..n).forEach { i ->
        combination(n, r, index + 1, i)
    }
}
