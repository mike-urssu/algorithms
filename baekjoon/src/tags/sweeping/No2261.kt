package tags.sweeping

/**
 * https://www.acmicpc.net/problem/2261
 */
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val coordinates = Array(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        x to y
    }.sortedBy { it.first }

    val candidates = sortedSetOf<Pair<Int, Int>>(Comparator { it, other ->
        val cy = it.second.compareTo(other.second)
        if (cy == 0) {
            it.first.compareTo(other.first)
        } else {
            cy
        }
    })
    candidates.add(coordinates[0])
    candidates.add(coordinates[1])
    var min = getDistance(coordinates[0], coordinates[1])
    var index = 0
    (2 until n).forEach { i ->
        val (px, py) = coordinates[i]
        while (index < i) {
            val cord = coordinates[index]
            if ((px - cord.first) * (px - cord.first) > min) {
                candidates.remove(cord)
                index++
            } else {
                break
            }
        }
        val d = sqrt(min.toDouble()).toInt() + 1
        val subset = candidates.subSet(-100000 to py - d, 100000 to py + d)
        subset.forEach { min = min.coerceAtMost(getDistance(coordinates[i], it)) }
        candidates.add(coordinates[i])
    }

    println(min)
}

private fun getDistance(cord1: Pair<Int, Int>, cord2: Pair<Int, Int>) =
    (cord2.first - cord1.first) * (cord2.first - cord1.first) + (cord2.second - cord1.second) * (cord2.second - cord1.second)
