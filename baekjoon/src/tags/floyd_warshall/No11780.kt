package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/11780
 */
private lateinit var previousPaths: Array<IntArray>
private lateinit var distances: Array<LongArray>

private const val MAX = 10_000_000_000L

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    previousPaths = Array(n + 1) { IntArray(n + 1) }
    distances = getDistances(n, m)

    (1..n).forEach { i ->
        println(
            distances[i].drop(1)
                .map {
                    if (it == MAX) {
                        0
                    } else {
                        it
                    }
                }.joinToString(" ")
        )
    }

    (1..n).forEach { src ->
        (1..n).forEach { dst ->
            val paths = mutableListOf<Int>()
            if (distances[src][dst] != MAX) {
                setPaths(paths, src, dst)
            }
            println("${paths.size} ${paths.joinToString(" ")}")
        }
    }
}

private fun getDistances(n: Int, m: Int): Array<LongArray> {
    val distances = Array(n + 1) { LongArray(n + 1) { MAX } }
    (1..n).forEach { i -> distances[i][i] = 0 }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        distances[a][b] = distances[a][b].coerceAtMost(c.toLong())
    }
    for (k in 1..n) {
        for (src in 1..n) {
            for (dst in 1..n) {
                if (distances[src][dst] > distances[src][k] + distances[k][dst]) {
                    distances[src][dst] = distances[src][k] + distances[k][dst]
                    previousPaths[src][dst] = k
                }
            }
        }
    }
    return distances
}

private fun setPaths(paths: MutableList<Int>, src: Int, dst: Int) {
    if (src == dst) {
        return
    }

    if (previousPaths[src][dst] == 0) {
        paths.add(src)
        paths.add(dst)
        return
    }

    val k = previousPaths[src][dst]
    setPaths(paths, src, k)
    paths.removeLast()
    setPaths(paths, k, dst)
}
