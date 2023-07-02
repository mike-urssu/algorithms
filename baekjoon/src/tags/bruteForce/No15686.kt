package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/15686
 */
import kotlin.math.absoluteValue

private lateinit var graph: Array<IntArray>
private lateinit var isSelected: BooleanArray
private val houses = mutableListOf<Pair<Int, Int>>()
private val chickenHouses = mutableListOf<Pair<Int, Int>>()

private var min = Int.MAX_VALUE

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    setLocations(n)
    isSelected = BooleanArray(chickenHouses.size)
    shutdownChickenHouses(n, m, 0, 0)
    println(min)
}

private fun setLocations(n: Int) {
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            when (graph[i][j]) {
                1 -> houses.add(Pair(i, j))
                2 -> chickenHouses.add(Pair(i, j))
            }
        }
    }
}

private fun shutdownChickenHouses(n: Int, m: Int, index: Int, count: Int) {
    if (m == count) {
        val distance = houses.sumOf { getDistance(it) }
        min = min.coerceAtMost(distance)
        return
    }

    for (i in index until isSelected.size) {
        if (!isSelected[i]) {
            isSelected[i] = true
            shutdownChickenHouses(n, m, i, count + 1)
            isSelected[i] = false
        }
    }
}

private fun getDistance(house: Pair<Int, Int>): Int {
    var min = Int.MAX_VALUE
    for (i in isSelected.indices) {
        if (isSelected[i]) {
            val row = chickenHouses[i].first
            val col = chickenHouses[i].second
            min = min.coerceAtMost((house.first - row).absoluteValue + (house.second - col).absoluteValue)
        }
    }
    return min
}
