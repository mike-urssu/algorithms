package tags.dp

/**
 * https://www.acmicpc.net/problem/10835
 */
private var n = 0
private lateinit var left: IntArray
private lateinit var right: IntArray
private lateinit var scores: Array<IntArray>

fun main() {
    n = readln().toInt()
    left = readln().split(" ").map { it.toInt() }.toIntArray()
    right = readln().split(" ").map { it.toInt() }.toIntArray()
    scores = Array(n) { IntArray(n) { -1 } }

    println(getScore(0, 0))
}

private fun getScore(l: Int, r: Int): Int {
    if (l == n || r == n) {
        return 0
    }

    if (scores[l][r] != -1) {
        return scores[l][r]
    }

    scores[l][r] = if (left[l] > right[r]) {
        maxOf(getScore(l + 1, r), getScore(l + 1, r + 1), right[r] + getScore(l, r + 1))
    } else {
        maxOf(getScore(l + 1, r), getScore(l + 1, r + 1))
    }
    return scores[l][r]
}
