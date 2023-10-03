package tags.binary_search

/**
 * https://www.acmicpc.net/problem/17266
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val positions = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getLeastHeight(n, m, positions))
}

private fun getLeastHeight(n: Int, m: Int, positions: IntArray): Int {
    var low = 0
    var high = n
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (canCover(n, m, positions, mid)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun canCover(n: Int, m: Int, positions: IntArray, height: Int): Boolean {
    if (positions[0] - height > 0) {
        return false
    }
    for (i in 0 until m - 1) {
        if (positions[i] + height < positions[i + 1] - height) {
            return false
        }
    }
    return positions.last() + height >= n
}
