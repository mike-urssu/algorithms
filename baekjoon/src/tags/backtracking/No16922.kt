package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16922
 */
private var n = 0
private lateinit var combination: IntArray
private val numbers = intArrayOf(50, 10, 5, 1)
private val sums = mutableSetOf<Int>()

fun main() {
    n = readln().toInt()
    combination = IntArray(n)
    combination(0, 0)
    println(sums.size)
}

private fun combination(index: Int, nIndex: Int) {
    if (index == n) {
        sums.add(combination.sum())
        return
    }

    (nIndex until 4).forEach { i ->
        combination[index] = numbers[i]
        combination(index + 1, i)
    }
}
