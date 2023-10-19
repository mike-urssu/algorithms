package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15655
 */
private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private val sequences = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.sorted().toIntArray().copyInto(this, 1)
    }
    combination = IntArray(m)

    (1..n).forEach { i ->
        combination(n, m, 0, i)
    }

    println(sequences)
}

private fun combination(n: Int, r: Int, cIndex: Int, nIndex: Int) {
    combination[cIndex] = numbers[nIndex]

    if (cIndex == r - 1) {
        sequences.append("${combination.joinToString(" ")}\n")
        return
    }

    (nIndex + 1..n).forEach { i ->
        combination(n, r, cIndex + 1, i)
    }
}
