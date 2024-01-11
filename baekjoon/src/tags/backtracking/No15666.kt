package tags.backtracking

/**
 * https://www.acmicpc.net/problem/15666
 */
private lateinit var numbers: IntArray
private lateinit var combination: IntArray

fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    numbers = readln().split(" ").map { it.toInt() }.distinct().sorted().toIntArray()
    combination = IntArray(m)
    combination(m, 0, 0)
}

private fun combination(n: Int, cIndex: Int, nIndex: Int) {
    if (n == cIndex) {
        println(combination.joinToString(" "))
        return
    }

    (nIndex until numbers.size).forEach { i ->
        combination[cIndex] = numbers[i]
        combination(n, cIndex + 1, i)
    }
}
