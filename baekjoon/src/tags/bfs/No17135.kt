package tags.bfs

/**
 * https://www.acmicpc.net/problem/17135
 */
import kotlin.math.abs

private var n = 0
private var m = 0
private var d = 0
private lateinit var graph: Array<IntArray>
private val archers = IntArray(3)
private var enemies = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    d = input[2]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 0 until m) {
        setArcherPositions(0, i)
    }

    println(enemies)
}

private fun setArcherPositions(index: Int, value: Int) {
    archers[index] = value

    if (index == archers.lastIndex) {
        val clone = Array(n) { i -> graph[i].copyOf() }
        enemies = enemies.coerceAtLeast(getRemovedEnemies(clone))
        return
    }

    for (i in value + 1 until m) {
        setArcherPositions(index + 1, i)
    }
}


private fun getRemovedEnemies(graph: Array<IntArray>): Int {
    var count = 0
    while (isEnemyExist(graph)) {
        val enemies = findEnemies(graph)
        count += enemies.size
        removeEnemies(graph, enemies)
        moveEnemies(graph)
    }
    return count
}

private fun isEnemyExist(graph: Array<IntArray>) =
    graph.any { row -> row.any { it == 1 } }

private fun findEnemies(graph: Array<IntArray>): Set<Pair<Int, Int>> {
    val enemies = mutableSetOf<Pair<Int, Int>>()
    archers.forEach { a ->
        val enemy = findEnemy(graph, a)
        enemy?.let { enemies.add(it) }
    }
    return enemies
}

private fun findEnemy(graph: Array<IntArray>, a: Int): Pair<Int, Int>? {
    var row = -1
    var col = -1
    var minDistance = Int.MAX_VALUE

    for (j in 0 until m) {
        for (i in n - 1 downTo 0) {
            val distance = getDistance(n, a, i, j)
            if (graph[i][j] == 1 && d >= distance && minDistance > distance) {
                row = i
                col = j
                minDistance = distance
            }
        }
    }

    return if (row == -1 || col == -1) {
        null
    } else {
        Pair(row, col)
    }
}

private fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int) =
    abs(x1 - x2) + abs(y1 - y2)

private fun removeEnemies(graph: Array<IntArray>, enemies: Set<Pair<Int, Int>>) {
    enemies.forEach { (i, j) -> graph[i][j]-- }
}

private fun moveEnemies(graph: Array<IntArray>) {
    for (j in 0 until m) {
        for (i in n - 1 downTo 1) {
            graph[i][j] = graph[i - 1][j]
        }
    }
    for (j in 0 until m) {
        graph[0][j] = 0
    }
}
