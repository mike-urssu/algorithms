package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17779
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var sections: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = getGraph(n)

    var gap = Int.MAX_VALUE
    (1..n).forEach { x ->
        (1..n).forEach { y ->
            (1..n).forEach { d1 ->
                (1..n).forEach { d2 ->
                    if (isInBoundary(x, y, d1, d2)) {
                        setSections(x, y, d1, d2)
                        gap = gap.coerceAtMost(getGap())
                    }
                }
            }
        }
    }
    println(gap)
}

private fun getGraph(n: Int): Array<IntArray> {
    val graph = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
        numbers.copyInto(graph[i], 1)
    }
    return graph
}

private fun isInBoundary(x: Int, y: Int, d1: Int, d2: Int) =
    (x + d1 <= n && y - d1 >= 1)
        && (x + d2 <= n && y + d2 <= n)
        && (x + d1 + d2 <= n && y - d1 + d2 <= n)

private fun setSections(x: Int, y: Int, d1: Int, d2: Int) {
    sections = Array(n + 1) { IntArray(n + 1) }
    section5(x, y, d1, d2)
    section1(x, y, d1)
    section2(x, y, d2)
    section3(x, y, d1, d2)
    section4(x, y, d1, d2)
}

private fun section5(x: Int, y: Int, d1: Int, d2: Int) {
    (0..d1).forEach { i ->
        (0..i).forEach { j ->
            sections[x + i][y - j] = 5
            sections[x + d1 + d2 - i][y - d1 + d2 + j] = 5
        }
    }

    (0..d2).forEach { i ->
        (0..i).forEach { j ->
            sections[x + i][y + j] = 5
            sections[x + d1 + d2 - i][y - d1 + d2 - j] = 5
        }
    }
}

private fun section1(x: Int, y: Int, d1: Int) {
    (1 until x + d1).forEach { i ->
        (1..y).forEach { j ->
            if (sections[i][j] == 0) {
                sections[i][j] = 1
            }
        }
    }
}

private fun section2(x: Int, y: Int, d2: Int) {
    (1..x + d2).forEach { i ->
        (y + 1..n).forEach { j ->
            if (sections[i][j] == 0) {
                sections[i][j] = 2
            }
        }
    }
}

private fun section3(x: Int, y: Int, d1: Int, d2: Int) {
    (x + d1..n).forEach { i ->
        (1 until y - d1 + d2).forEach { j ->
            if (sections[i][j] == 0) {
                sections[i][j] = 3
            }
        }
    }
}

private fun section4(x: Int, y: Int, d1: Int, d2: Int) {
    (x + d2 + 1..n).forEach { i ->
        (y - d1 + d2..n).forEach { j ->
            if (sections[i][j] == 0) {
                sections[i][j] = 4
            }
        }
    }
}

private fun getGap(): Int {
    val prefixSum = IntArray(6)
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            when (sections[i][j]) {
                1 -> prefixSum[1] += graph[i][j]
                2 -> prefixSum[2] += graph[i][j]
                3 -> prefixSum[3] += graph[i][j]
                4 -> prefixSum[4] += graph[i][j]
                else -> prefixSum[5] += graph[i][j]
            }
        }
    }
    return (1..5).maxOf { prefixSum[it] } - (1..5).minOf { prefixSum[it] }
}
