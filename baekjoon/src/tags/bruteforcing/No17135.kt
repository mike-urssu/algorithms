package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17135
 */
import kotlin.math.absoluteValue

private var n = 0
private var m = 0
private var d = 0

private lateinit var graph: Array<IntArray>
private lateinit var archers: BooleanArray

private var max = 0

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    d = numbers[2]

    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    archers = BooleanArray(m)

    combination(m, 3, 0, 0, 0)

    println(max)
}

private var removedEnemies = 0

private fun combination(n: Int, r: Int, index: Int, from: Int, count: Int) {
    if (r == count) {
        removedEnemies = 0
        val copiedGraph = Array(graph.size) { i -> graph[i].copyOf() }
        removeEnemies(copiedGraph, archers)
        max = max.coerceAtLeast(removedEnemies)
        return
    }

    (from until n).forEach { i ->
        if (!archers[i]) {
            archers[i] = true
            combination(n, r, index + 1, i, count + 1)
            archers[i] = false
        }
    }
}

private fun removeEnemies(graph: Array<IntArray>, archers: BooleanArray) {
    repeat(n) {
        val enemies = mutableSetOf<Pair<Int, Int>>()
        archers.indices.forEach { i ->
            if (archers[i]) {
                findClosestEnemy(graph, i)?.let { enemies.add(it) }
            }
        }
        enemies.forEach {
            graph[it.first][it.second]--
            removedEnemies++
        }

        moveDownEnemies(graph)
    }
}

private fun findClosestEnemy(graph: Array<IntArray>, index: Int): Pair<Int, Int>? {
    var row = -1
    var col = -1
    var minDistance = Int.MAX_VALUE

    for (j in 0 until m) {
        for (i in n - 1 downTo 1) {
            if (graph[i][j] == 1) {
                val distance = getDistance(n, index, i, j)
                if (d >= distance && minDistance > distance) {
                    minDistance = distance
                    row = i
                    col = j
                }
            }
        }
    }

    return if (minDistance == Int.MAX_VALUE) {
        null
    } else {
        Pair(row, col)
    }
}

private fun moveDownEnemies(graph: Array<IntArray>) {
    (n - 2 downTo 0).forEach { i -> graph[i + 1] = graph[i] }
    graph[0] = IntArray(m)
}

private fun getDistance(r1: Int, c1: Int, r2: Int, c2: Int) = (r2 - r1).absoluteValue + (c2 - c1).absoluteValue
