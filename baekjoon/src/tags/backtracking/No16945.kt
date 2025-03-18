package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16945
 */
import java.util.Scanner
import kotlin.math.absoluteValue

private lateinit var graph: IntArray
private val combination = IntArray(9)
private val isVisited = BooleanArray(10)
private var min = Int.MAX_VALUE

fun main() {
    val scanner = Scanner(System.`in`)
    graph = IntArray(9) { scanner.nextInt() }
    combination(0)
    println(min)
}

private fun combination(r: Int) {
    if (r == 9) {
        if (isMagicSquare()) {
            val sum = (0 until 9).sumOf { (graph[it] - combination[it]).absoluteValue }
            min = min.coerceAtMost(sum)
        }
        return
    }

    (1..9).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[r] = i
            combination(r + 1)
            isVisited[i] = false
        }
    }
}

private fun isMagicSquare(): Boolean {
    val sum = combination.take(3).sum()

    (0..2).forEach { i ->
        if (intArrayOf(0, 3, 6).sumOf { combination[it + i] } != sum) {
            return false
        }
    }

    (0..2).forEach { i ->
        if (intArrayOf(0, 1, 2).sumOf { combination[it + i * 3] } != sum) {
            return false
        }
    }

    if (intArrayOf(0, 4, 8).sumOf { combination[it] } != sum) {
        return false
    }

    if (intArrayOf(2, 4, 6).sumOf { combination[it] } != sum) {
        return false
    }

    return true
}
