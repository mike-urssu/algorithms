package tags.mst

/**
 * https://www.acmicpc.net/problem/4386
 */
import kotlin.math.pow
import kotlin.math.sqrt

private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    val coordinates = mutableMapOf<Pair<Double, Double>, Int>().apply {
        repeat(n) { i ->
            val (x, y) = readln().split(" ").map { it.toDouble() }
            this[Pair(x, y)] = i
        }
    }

    val distances = getDistances(coordinates)
    println(String.format("%.2f", getMinimumDistance(n, distances)))
}

private fun getDistances(coordinates: Map<Pair<Double, Double>, Int>): List<Triple<Int, Int, Double>> {
    val points = mutableListOf<Triple<Int, Int, Double>>()
    for ((i, p1) in coordinates.keys.withIndex()) {
        for ((j, p2) in coordinates.keys.withIndex()) {
            points.add(Triple(i, j, getDistance(p1, p2)))
        }
    }
    points.sortWith { it, other ->
        it.third.compareTo(other.third)
    }
    return points
}

private fun getDistance(p1: Pair<Double, Double>, p2: Pair<Double, Double>) =
    sqrt(((p2.first - p1.first).pow(2) + (p2.second - p1.second).pow(2)))

private fun getMinimumDistance(n: Int, points: List<Triple<Int, Int, Double>>): Double {
    parents = IntArray(n + 1) { it }

    var mst = 0.0
    points.forEach { (a, b, distance) ->
        if (find(a) != find(b)) {
            union(a, b)
            mst += distance
        }
    }
    return mst
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
