package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1027
 */
fun main() {
    val n = readln().toInt()
    val buildings = readln().split(" ").map { it.toInt() }

    var max = 0
    for (i in 0 until n) {
        val count = getLeftValidBuildings(buildings, i) + getRightValidBuildings(buildings, i)
        max = max.coerceAtLeast(count)
    }

    println(max)
}

private fun getLeftValidBuildings(buildings: List<Int>, index: Int): Int {
    var count = 0
    var inclination = Double.POSITIVE_INFINITY
    for (i in index - 1 downTo 0) {
        val nextInclination = getInclination(Pair(index, buildings[index]), Pair(i, buildings[i]))
        if (nextInclination < inclination) {
            inclination = nextInclination
            count++
        }
    }
    return count
}

private fun getRightValidBuildings(buildings: List<Int>, index: Int): Int {
    var count = 0
    var inclination = Double.NEGATIVE_INFINITY
    for (i in index + 1 until buildings.size) {
        val nextInclination = getInclination(Pair(index, buildings[index]), Pair(i, buildings[i]))
        if (nextInclination > inclination) {
            inclination = nextInclination
            count++
        }
    }
    return count
}

private fun getInclination(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>) =
    (pair2.second - pair1.second).toDouble() / (pair2.first - pair1.first)
