package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15657
 */
private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private val sequences = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    combination = IntArray(m)
    (0 until n).forEach { combination(n, m, 0, it) }
    println(sequences)
}

private fun combination(n: Int, r: Int, cIndex: Int, nIndex: Int) {
    combination[cIndex] = numbers[nIndex]

    if (cIndex == r - 1) {
        sequences.append("${combination.joinToString(" ")}\n")
        return
    }

    (nIndex until n).forEach { combination(n, r, cIndex + 1, it) }
}
