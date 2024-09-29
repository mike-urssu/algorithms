package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14620
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var flowers: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    flowers = getFlowers()

    var min = Int.MAX_VALUE
    for (i in n + 1 until n * n - n - 3) {
        if (i % n == 0 || i % n == n - 1) {
            continue
        }
        for (j in i + 1 until n * n - n - 2) {
            if (j % n == 0 || j % n == n - 1) {
                continue
            }
            for (k in j + 1 until n * n - n - 1) {
                if (k % n == 0 || k % n == n - 1) {
                    continue
                }
                if (!isOverlapped(i, j, k)) {
                    min = min.coerceAtMost(flowers[i / n][i % n] + flowers[j / n][j % n] + flowers[k / n][k % n])
                }
            }
        }
    }
    println(min)
}

private val dx = intArrayOf(0, -1, 0, 1, 0)
private val dy = intArrayOf(0, 0, -1, 0, 1)

private fun getFlowers(): Array<IntArray> {
    val flowers = Array(n) { IntArray(n) }
    (1 until n - 1).forEach { x ->
        (1 until n - 1).forEach { y ->
            (0 until 5).forEach { k ->
                val nextX = x + dx[k]
                val nextY = y + dy[k]
                flowers[x][y] += graph[nextX][nextY]
            }
        }
    }
    return flowers
}

private fun isOverlapped(i: Int, j: Int, k: Int) =
    isOverlapped(i, j) || isOverlapped(j, k) || isOverlapped(k, i)

private fun isOverlapped(i: Int, j: Int): Boolean {
    val x1 = i / n
    val y1 = i % n
    val x2 = j / n
    val y2 = j % n

    return if (x1 == x2) {
        y1 - y2 in -2..2
    } else if (x1 - x2 in -1..1) {
        y1 - y2 in -1..1
    } else if (x1 - x2 in -2..2) {
        y1 == y2
    } else {
        false
    }
}
