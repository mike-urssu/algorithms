package tags.divide_and_conquer

/**
 * https://www.acmicpc.net/problem/1780
 */
private lateinit var graph: Array<IntArray>
private val papers = intArrayOf(0, 0, 0)

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    countPapers(0, n, 0, n)
    papers.forEach { println(it) }
}

private fun countPapers(rowFirst: Int, rowLast: Int, colFirst: Int, colLast: Int) {
    if (rowFirst == rowLast - 1 && colFirst == colLast - 1) {
        when (graph[rowFirst][colFirst]) {
            -1 -> papers[0]++
            0 -> papers[1]++
            1 -> papers[2]++
        }
        return
    }

    if (isFilled(rowFirst, rowLast, colFirst, colLast, -1)) {
        papers[0]++
    } else if (isFilled(rowFirst, rowLast, colFirst, colLast, 0)) {
        papers[1]++
    } else if (isFilled(rowFirst, rowLast, colFirst, colLast, 1)) {
        papers[2]++
    } else {
        val rowSecond = rowFirst + (rowLast - rowFirst) / 3
        val rowThird = rowFirst + (rowLast - rowFirst) / 3 * 2
        val colSecond = colFirst + (colLast - colFirst) / 3
        val colThird = colFirst + (colLast - colFirst) / 3 * 2

        countPapers(rowFirst, rowSecond, colFirst, colSecond)
        countPapers(rowFirst, rowSecond, colSecond, colThird)
        countPapers(rowFirst, rowSecond, colThird, colLast)

        countPapers(rowSecond, rowThird, colFirst, colSecond)
        countPapers(rowSecond, rowThird, colSecond, colThird)
        countPapers(rowSecond, rowThird, colThird, colLast)

        countPapers(rowThird, rowLast, colFirst, colSecond)
        countPapers(rowThird, rowLast, colSecond, colThird)
        countPapers(rowThird, rowLast, colThird, colLast)
    }
}

private fun isFilled(rowFirst: Int, rowLast: Int, colFirst: Int, colLast: Int, v: Int) =
    (rowFirst until rowLast).all { i ->
        (colFirst until colLast).all { j ->
            graph[i][j] == v
        }
    }
