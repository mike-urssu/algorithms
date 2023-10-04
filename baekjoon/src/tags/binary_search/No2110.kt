package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2110
 */
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val houses = IntArray(n) { readln().toInt() }.sorted().toIntArray()
    println(getMaxDistance(n, c, houses))
}

private fun getMaxDistance(n: Int, c: Int, houses: IntArray): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (isValid(houses, n, c, mid)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isValid(houses: IntArray, n: Int, c: Int, distance: Int): Boolean {
    var count = 1
    var min = houses[0]
    for (i in 0 until n - 1) {
        if (houses[i + 1] - min > distance) {
            min = houses[i + 1]
            count++
        }
    }
    return c > count
}
