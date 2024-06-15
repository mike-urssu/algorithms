package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/3197
 */
import java.util.LinkedList
import java.util.Queue

private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>

private lateinit var swan: Queue<Pair<Int, Int>>
private lateinit var isVisited: Array<BooleanArray>

private lateinit var water: Queue<Pair<Int, Int>>
private lateinit var isWaterVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }

    val (src, dst) = find()
    swan = LinkedList()
    isVisited = Array(r) { BooleanArray(c) }
    water = LinkedList()
    isWaterVisited = Array(r) { BooleanArray(c) }
    init(src)

    println(getDay(dst))
}

private fun find(): List<Pair<Int, Int>> {
    val coordinates = mutableListOf<Pair<Int, Int>>()
    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (graph[i][j] == 'L') {
                coordinates.add(i to j)
            }
        }
    }
    return coordinates
}

private fun init(src: Pair<Int, Int>) {
    swan.add(src)
    visitWater()
    isVisited[src.first][src.second] = true

    (0 until r).forEach { i ->
        (0 until c).forEach { j ->
            if (graph[i][j] == '.' || graph[i][j] == 'L') {
                water.add(i to j)
                isWaterVisited[i][j] = true
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getDay(dst: Pair<Int, Int>): Int {
    var day = 0
    while (!isVisited[dst.first][dst.second]) {
        meltWater()
        visitWater()
        day++
    }
    return day
}

private fun meltWater() {
    val nextWater: Queue<Pair<Int, Int>> = LinkedList()
    while (water.isNotEmpty()) {
        val (x, y) = water.poll()
        for (k in 0 until 4) {
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 'X' && !isWaterVisited[nextX][nextY]) {
                graph[nextX][nextY] = '.'
                nextWater.add(nextX to nextY)
                isWaterVisited[nextX][nextY] = true
            }
        }
    }
    water = nextWater
}

private fun visitWater() {
    val nextSwan: Queue<Pair<Int, Int>> = LinkedList()
    while (swan.isNotEmpty()) {
        val (x, y) = swan.poll()
        for (k in 0 until 4) {
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == '.' || graph[nextX][nextY] == 'L') {
                    swan.add(nextX to nextY)
                } else {
                    nextSwan.add(nextX to nextY)
                }
                isVisited[nextX][nextY] = true
            }
        }
    }
    swan = nextSwan
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
