package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1007
 */
import kotlin.math.pow
import kotlin.math.sqrt

private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()

private lateinit var coordinates: Array<Pair<Double, Double>>
private lateinit var combination: IntArray

private var min = Double.MAX_VALUE

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        min = Double.MAX_VALUE
        val n = reader.readLine().toInt()
        coordinates = Array(n) {
            val (x, y) = reader.readLine().split(" ").map { it.toDouble() }
            x to y
        }
        combination = IntArray(n / 2)

        if (n == 2) {
            min = calculate()
        } else {
            (1 until n).forEach { i ->
                combination[1] = i
                combination(n, n / 2, i, 2)
            }
        }

        writer.write("$min\n")
    }
    writer.flush()
}

private fun combination(n: Int, r: Int, index: Int, cIndex: Int) {
    if (cIndex == r) {
        val vectorMatching = calculate()
        min = min.coerceAtMost(vectorMatching)
        return
    }

    (index + 1 until n).forEach { i ->
        combination[cIndex] = i
        combination(n, r, i, cIndex + 1)
    }
}

private fun calculate(): Double {
    val sumX1 = coordinates.sumOf { it.first }
    val sumY1 = coordinates.sumOf { it.second }
    val sumX2 = combination.sumOf { coordinates[it].first } * 2
    val sumY2 = combination.sumOf { coordinates[it].second } * 2
    return sqrt((sumX1 - sumX2).pow(2) + (sumY1 - sumY2).pow(2))
}
