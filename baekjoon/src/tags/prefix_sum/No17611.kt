package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/17611
 */
private const val DELTA = 500000
private val xs = IntArray(1000001)
private val ys = IntArray(1000001)

fun main() {
    val n = readln().toInt()
    val points = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    for (i in 0 until n) {
        val x1 = points[i][0]
        val y1 = points[i][1]
        val x2 = points[(i + 1) % n][0]
        val y2 = points[(i + 1) % n][1]

        if (x1 == x2) {
            val minY = minOf(y1, y2)
            val maxY = maxOf(y1, y2)
            ys[minY + DELTA]++
            ys[maxY + DELTA]--
        } else {
            val minX = minOf(x1, x2)
            val maxX = maxOf(x1, x2)
            xs[minX + DELTA]++
            xs[maxX + DELTA]--
        }
    }

    val prefixSumOfXs = xs.runningFold(0, Int::plus)
    val prefixSumOfYs = ys.runningFold(0, Int::plus)

    val max = maxOf(prefixSumOfXs.max(), prefixSumOfYs.max())
    println(max)
}
