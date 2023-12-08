package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/2630
 */
private lateinit var paper: Array<IntArray>
private var white = 0
private var blue = 0

fun main() {
    val n = readln().toInt()
    paper = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    countPapers(0, n, 0, n)
    println(white)
    println(blue)
}

private fun countPapers(rowFirst: Int, rowLast: Int, colFirst: Int, colLast: Int) {
    if (isSameColor(rowFirst, rowLast, colFirst, colLast, 0)) {
        white++
        return
    } else if (isSameColor(rowFirst, rowLast, colFirst, colLast, 1)) {
        blue++
        return
    }

    val rowMid = (rowFirst + rowLast) shr 1
    val colMid = (colFirst + colLast) shr 1

    countPapers(rowFirst, rowMid, colFirst, colMid)
    countPapers(rowFirst, rowMid, colMid, colLast)
    countPapers(rowMid, rowLast, colFirst, colMid)
    countPapers(rowMid, rowLast, colMid, colLast)
}

private fun isSameColor(rowFirst: Int, rowLast: Int, colFirst: Int, colLast: Int, color: Int) =
    (rowFirst until rowLast).all { i ->
        (colFirst until colLast).all { j -> paper[i][j] == color }
    }
