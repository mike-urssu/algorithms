package tags.geometry

/**
 * https://www.acmicpc.net/problem/25308
 */
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private lateinit var numbers: DoubleArray
private val combination = DoubleArray(8)
private val isVisited = BooleanArray(8)

private var count = 0

fun main() {
    numbers = readln().split(" ").map { it.toDouble() }.toDoubleArray()
    combination(0)
    println(count)
}

private fun combination(index: Int) {
    if (index == 8) {
        if (isConvexPolygon()) {
            count++
        }
        return
    }

    for (i in 0 until 8) {
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = numbers[i]
            combination(index + 1)
            isVisited[i] = false
        }
    }
}

private fun isConvexPolygon() =
    (0 until 8).all { i ->
        val p1 = Pair(0.0, combination[i])
        val p2 = Pair(combination[(i + 1) % 8] * cos(PI / 4), combination[(i + 1) % 8] * sin(PI / 4))
        val p3 = Pair(combination[(i + 2) % 8], 0.0)
        isConvex(p1, p2, p3)
    }

private fun isConvex(p1: Pair<Double, Double>, p2: Pair<Double, Double>, p3: Pair<Double, Double>) =
    p2.second >= (p3.second - p1.second) / (p3.first - p1.first) * p2.first + p1.second
