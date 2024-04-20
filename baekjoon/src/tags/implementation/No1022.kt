package tags.implementation

/**
 * https://www.acmicpc.net/problem/1022
 */
import kotlin.math.abs

private lateinit var swirl: Array<IntArray>

fun main() {
    val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
    swirl = getSwirl(r1, c1, r2, c2)
    printSwirl(r1, c1, r2, c2)
}

private lateinit var rowBoundary: IntRange
private lateinit var colBoundary: IntRange

private fun getSwirl(r1: Int, c1: Int, r2: Int, c2: Int): Array<IntArray> {
    val swirl = Array(r2 - r1 + 1) { IntArray(c2 - c1 + 1) }
    val n = intArrayOf(r1, c1, r2, c2).maxOf { abs(it) } * 2 + 1
    val c = n / 2
    val dx = c + r1
    val dy = c + c1
    rowBoundary = r1..r2
    colBoundary = c1..c2

    var num = 1
    if (isInBoundary(n / 2 - c, n / 2 - c)) {
        swirl[n / 2 - dx][n / 2 - dy] = num
    }
    num++

    for (k in 1..n / 2) {
        (n / 2 + (k - 1) downTo n / 2 - k).forEach { i ->
            if (isInBoundary(i - c, n / 2 + k - c)) {
                swirl[i - dx][n / 2 + k - dy] = num
            }
            num++
        }
        (n / 2 + (k - 1) downTo n / 2 - k).forEach { j ->
            if (isInBoundary(n / 2 - k - c, j - c)) {
                swirl[n / 2 - k - dx][j - dy] = num
            }
            num++
        }
        (n / 2 - (k - 1)..n / 2 + k).forEach { i ->
            if (isInBoundary(i - c, n / 2 - k - c)) {
                swirl[i - dx][n / 2 - k - dy] = num
            }
            num++
        }
        (n / 2 - (k - 1)..n / 2 + k).forEach { j ->
            if (isInBoundary(n / 2 + k - c, j - c)) {
                swirl[n / 2 + k - dx][j - dy] = num
            }
            num++
        }
    }
    return swirl
}

private fun isInBoundary(x: Int, y: Int) =
    x in rowBoundary && y in colBoundary

private fun printSwirl(r1: Int, c1: Int, r2: Int, c2: Int) {
    var length = 0
    for (i in 0 until r2 - r1 + 1) {
        for (j in 0 until c2 - c1 + 1) {
            length = length.coerceAtLeast(swirl[i][j].toString().length)
        }
    }

    for (i in 0 until r2 - r1 + 1) {
        for (j in 0 until c2 - c1 + 1) {
            print(String.format("%${length}d ", swirl[i][j]))
        }
        println()
    }
}
