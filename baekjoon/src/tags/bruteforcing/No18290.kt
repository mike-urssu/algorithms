package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/18290
 */
private var n = 0
private var m = 0
private var k = 0
private lateinit var numbers: Array<IntArray>
private lateinit var combination: Array<Pair<Int, Int>>
private var max = Int.MIN_VALUE

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]
    numbers = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    combination = Array(k) { Pair(0, 0) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            combination(i, j, 0)
        }
    }

    println(max)
}

private fun combination(x: Int, y: Int, cIndex: Int) {
    combination[cIndex] = Pair(x, y)
    if (cIndex == k - 1) {
        if (isValid()) {
            val sum = combination.sumOf { (i, j) -> numbers[i][j] }
            max = max.coerceAtLeast(sum)
        }
        return
    }

    for (j in y + 1 until m) {
        combination(x, j, cIndex + 1)
    }

    for (i in x + 1 until n) {
        for (j in 0 until m) {
            combination(i, j, cIndex + 1)
        }
    }
}

private val d = arrayOf(Pair(0, 0), Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

private fun isValid(): Boolean {
    for (i in 0 until k - 1) {
        val (x1, y1) = combination[i]
        for (j in i + 1 until k) {
            val (x2, y2) = combination[j]
            if (Pair(x1 - x2, y1 - y2) in d) {
                return false
            }
        }
    }
    return true
}
