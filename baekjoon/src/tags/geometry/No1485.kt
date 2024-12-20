package tags.geometry

/**
 * https://www.acmicpc.net/problem/1485
 */
fun main() {
    val t = readln().toInt()
    repeat(t) { _ ->
        val coordinates = getCoordinates()
        if (canCreateSquare(coordinates)) {
            println(1)
        } else {
            println(0)
        }
    }
}

private fun getCoordinates(): List<Pair<Double, Double>> {
    return Array(4) {
        val (x, y) = readln().split(" ").map { it.toDouble() }
        x to y
    }.sortedWith { it, other ->
        val cx = it.first.compareTo(other.first)
        if (cx == 0) {
            it.second.compareTo(other.second)
        } else {
            cx
        }
    }
}

private fun canCreateSquare(coordinates: List<Pair<Double, Double>>): Boolean {
    val averageX = coordinates.sumOf { it.first } / 4
    val averageY = coordinates.sumOf { it.second } / 4
    val average = averageX to averageY

    val d = getDistance(average, coordinates[0])
    if (!coordinates.all { p -> getDistance(average, p) == d }) {
        return false
    }

    return (getDistance(coordinates[0], coordinates[1]) == getDistance(coordinates[0], coordinates[2])) ||
        getDistance(coordinates[0], coordinates[1]) == getDistance(coordinates[0], coordinates[2])
}

private fun getDistance(p1: Pair<Double, Double>, p2: Pair<Double, Double>): Double {
    return (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)
}
