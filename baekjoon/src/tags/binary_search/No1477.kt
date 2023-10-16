package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1477
 */
fun main() {
    val (n, m, l) = readln().split(" ").map { it.toInt() }
    val distances = getDistances(n, l)
    println(findMinimumDistance(distances, m))
}

private fun getDistances(n: Int, l: Int): IntArray {
    val distances = mutableListOf<Int>()
    distances.add(0)
    distances.add(l)
    if (n != 0) {
        distances.addAll(readln().split(" ").map { it.toInt() })
    }
    return distances.sorted().toIntArray()
}

private fun findMinimumDistance(distances: IntArray, m: Int): Int {
    var low = 0
    var high = 1000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (canBuild(distances, mid, m)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun canBuild(distances: IntArray, distance: Int, m: Int) =
    (1 until distances.size).sumOf { i -> (distances[i] - distances[i - 1] - 1) / distance } <= m
