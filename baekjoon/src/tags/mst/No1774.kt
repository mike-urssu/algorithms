package tags.mst

/**
 * https://www.acmicpc.net/problem/1774
 */
import kotlin.math.pow
import kotlin.math.sqrt

private lateinit var parents: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val coordinates = getCoordinates(n)

    parents = IntArray(n + 1) { it }
    connect(m)

    println(String.format("%.2f", getMinimumDistance(coordinates)))
}

private fun getCoordinates(n: Int) =
    Array(n) {
        val (x, y) = readln().split(" ").map { it.toDouble() }
        Pair(x, y)
    }

private fun connect(m: Int) {
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        union(x, y)
    }
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

private fun getMinimumDistance(coordinates: Array<Pair<Double, Double>>): Double {
    val distances = getDistances(coordinates)
    var distance = 0.0
    distances.forEach { (a, b, d) ->
        if (find(a) != find(b)) {
            union(a, b)
            distance += d
        }
    }
    return distance
}

private fun getDistances(coordinates: Array<Pair<Double, Double>>): List<Triple<Int, Int, Double>> {
    val distances = mutableListOf<Triple<Int, Int, Double>>()
    coordinates.forEachIndexed { i, p1 ->
        coordinates.forEachIndexed { j, p2 ->
            distances.add(Triple(i + 1, j + 1, getDistance(p1, p2)))
        }
    }
    distances.sortWith { it, other ->
        it.third.compareTo(other.third)
    }
    return distances
}

private fun getDistance(p1: Pair<Double, Double>, p2: Pair<Double, Double>) =
    sqrt((p2.first - p1.first).pow(2) + (p2.second - p1.second).pow(2))
