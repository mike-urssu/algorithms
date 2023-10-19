package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15654
 */
import java.lang.StringBuilder

private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray
private val sequences = StringBuilder()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    numbers = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.sorted().toIntArray().copyInto(this, 1)
    }
    combination = IntArray(m)
    isVisited = BooleanArray(n + 1)

    (1..n).forEach { i ->
        isVisited[i] = true
        combination(n, m, 0, numbers[i])
        isVisited[i] = false
    }

    println(sequences)
}

private fun combination(n: Int, r: Int, index: Int, value: Int) {
    combination[index] = value
    if (index == r - 1) {
        sequences.append("${combination.joinToString(" ")}\n")
        return
    }

    (1..n).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination(n, r, index + 1, numbers[i])
            isVisited[i] = false
        }
    }
}
