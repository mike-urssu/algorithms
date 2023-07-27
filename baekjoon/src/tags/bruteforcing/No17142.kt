package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17142
 */
import java.util.Queue
import java.util.LinkedList

private var n = 0
private var m = 0

private lateinit var graph: Array<IntArray>
private lateinit var viruses: MutableList<Pair<Int, Int>>
private lateinit var isVisited: BooleanArray
private var emptySpaces = 0

private lateinit var combination: IntArray

private var min = Int.MAX_VALUE

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    viruses = getViruses(n)
    isVisited = BooleanArray(viruses.size)

    emptySpaces = graph.sumOf { row -> row.count { it == 0 } }
    if (emptySpaces == 0) {
        println(0)
    } else {
        combination = IntArray(m)
        combination(0, 0)
        if (min == Int.MAX_VALUE) {
            println(-1)
        } else {
            println(min)
        }
    }
}

private fun getViruses(n: Int): MutableList<Pair<Int, Int>> {
    val viruses = mutableListOf<Pair<Int, Int>>()
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == 2) {
                viruses.add(Pair(i, j))
            }
        }
    }
    return viruses
}

private fun combination(index: Int, from: Int) {
    if (m == index) {
        val activatedViruses = combination.map { i -> viruses[i] }
        spreadViruses(activatedViruses, emptySpaces)
        return
    }

    for (i in from until isVisited.size) {
        combination[index] = i
        combination(index + 1, i + 1)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun spreadViruses(activatedViruses: List<Pair<Int, Int>>, emptySpaces: Int) {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
            .apply { activatedViruses.forEach { this.add(Triple(it.first, it.second, 0)) } }
    val isVisited = Array(n) { BooleanArray(n) }
            .apply { activatedViruses.forEach { this[it.first][it.second] = true } }
    var spaces = emptySpaces

    while (queue.isNotEmpty()) {
        val virus = queue.poll()
        for (i in 0 until 4) {
            val nextX = virus.first + dx[i]
            val nextY = virus.second + dy[i]
            if (isInBoundary(n, nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] != 1) {
                if (graph[nextX][nextY] == 0) {
                    spaces--
                }

                if (spaces == 0) {
                    min = min.coerceAtMost(virus.third + 1)
                    return
                }

                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, virus.third + 1))
            }
        }
    }
}

private fun isInBoundary(n: Int, x: Int, y: Int) = x in 0 until n && y in 0 until n
