package tags.dp

/**
 * https://www.acmicpc.net/problem/2618
 */
import kotlin.math.abs

private lateinit var pathA: MutableList<IntArray>
private lateinit var pathB: MutableList<IntArray>
private lateinit var distances: Array<IntArray>

fun main() {
    val n = readln().toInt()
    val w = readln().toInt()
    setPaths(n, w)

    distances = getDistances(w)
    println(distances[0][0])

    val orders = getOrders(w)
    orders.forEach { println(it) }
}

private fun setPaths(n: Int, w: Int) {
    pathA = mutableListOf()
    pathB = mutableListOf()

    pathA.add(intArrayOf(1, 1))
    pathB.add(intArrayOf(n, n))
    repeat(w) {
        val path = readln().split(" ").map { it.toInt() }.toIntArray()
        pathA.add(path)
        pathB.add(path)
    }
}

private fun getDistances(w: Int): Array<IntArray> {
    val distances = Array(w + 1) { IntArray(w + 1) { -1 } }
    getDistance(w, distances, 0, 0)
    return distances
}

private fun getDistance(w: Int, distances: Array<IntArray>, indexA: Int, indexB: Int): Int {
    if (indexA == w || indexB == w) {
        distances[indexA][indexB] = 0
        return 0
    }

    if (distances[indexA][indexB] != -1) {
        return distances[indexA][indexB]
    }

    val nextIndex = indexA.coerceAtLeast(indexB) + 1

    val distanceA = abs(pathA[indexA][0] - pathA[nextIndex][0]) + abs(pathA[indexA][1] - pathA[nextIndex][1])
    val distanceB = abs(pathB[indexB][0] - pathB[nextIndex][0]) + abs(pathB[indexB][1] - pathB[nextIndex][1])

    val prefixSumA = getDistance(w, distances, nextIndex, indexB) + distanceA
    val prefixSumB = getDistance(w, distances, indexA, nextIndex) + distanceB

    distances[indexA][indexB] = prefixSumA.coerceAtMost(prefixSumB)
    return distances[indexA][indexB]
}

private fun getOrders(w: Int): IntArray {
    val orders = IntArray(w)
    setOrders(w, orders, 0, 0)
    return orders
}

private fun setOrders(w: Int, orders: IntArray, indexA: Int, indexB: Int) {
    if (indexA == w || indexB == w) {
        return
    }

    val nextIndex = indexA.coerceAtLeast(indexB) + 1

    val distanceA = abs(pathA[indexA][0] - pathA[nextIndex][0]) + abs(pathA[indexA][1] - pathA[nextIndex][1])
    val distanceB = abs(pathB[indexB][0] - pathB[nextIndex][0]) + abs(pathB[indexB][1] - pathB[nextIndex][1])

    val prefixSumA = distances[nextIndex][indexB] + distanceA
    val prefixSumB = distances[indexA][nextIndex] + distanceB

    if (prefixSumA < prefixSumB) {
        orders[nextIndex - 1] = 1
        setOrders(w, orders, nextIndex, indexB)
    } else {
        orders[nextIndex - 1] = 2
        setOrders(w, orders, indexA, nextIndex)
    }
}
