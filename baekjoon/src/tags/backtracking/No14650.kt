package tags.backtracking

/**
 * https://www.acmicpc.net/problem/14650
 */
private lateinit var combination: IntArray
private var count = 0

fun main() {
    val n = readln().toInt()
    combination = IntArray(n)
    (1..2).forEach { combination(n, 0, it) }
    println(count)
}

private fun combination(n: Int, r: Int, v: Int) {
    combination[r] = v

    if (r == n - 1) {
        if (combination[0] != 0 && combination.sum() % 3 == 0) {
            count++
        }
        return
    }

    (0..2).forEach { combination(n, r + 1, it) }
}
