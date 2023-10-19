package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15651
 */
private lateinit var combination: IntArray
private val sequence = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    combination = IntArray(m)
    (1..n).forEach { combination(n, m, 0, it) }
    println(sequence)
}

private fun combination(n: Int, r: Int, index: Int, value: Int) {
    combination[index] = value
    if (index == r - 1) {
        sequence.append("${combination.joinToString(" ")}\n")
        return
    }

    (1..n).forEach { combination(n, r, index + 1, it) }
}
