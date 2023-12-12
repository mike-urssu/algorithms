package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/1992
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    println(zip(0 until n, 0 until n))
}

private fun zip(rowRange: IntRange, colRange: IntRange): String {
    if (isFilled(rowRange, colRange, 1)) {
        return "1"
    } else if (isFilled(rowRange, colRange, 0)) {
        return "0"
    }

    val rowMid = (rowRange.first + rowRange.last) shr 1
    val colMid = (colRange.first + colRange.last) shr 1
    return "(" +
            zip(rowRange.first..rowMid, colRange.first..colMid) +
            zip(rowRange.first..rowMid, colMid + 1..colRange.last) +
            zip(rowMid + 1..rowRange.last, colRange.first..colMid) +
            zip(rowMid + 1..rowRange.last, colMid + 1..colRange.last) +
            ")"
}

private fun isFilled(rowRange: IntRange, colRange: IntRange, color: Int) =
    rowRange.all { i ->
        colRange.all { j ->
            graph[i][j] == color
        }
    }
