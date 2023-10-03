package tags.bfs

/**
 * https://www.acmicpc.net/problem/21736
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }

    val people = countPeople()
    if (people == 0) {
        println("TT")
    } else {
        println(people)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun countPeople(): Int {
    var count = 0
    val src = findSrc()
    val isVisited = Array(n) { BooleanArray(m) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[src.first][src.second] = true
    queue.add(src)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == 'O') {
                    isVisited[nextX][nextY] = true
                    queue.add(Pair(nextX, nextY))
                } else if (graph[nextX][nextY] == 'P') {
                    count++
                    isVisited[nextX][nextY] = true
                    queue.add(Pair(nextX, nextY))
                }
            }
        }
    }

    return count
}

private fun findSrc(): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'I') {
                return Pair(i, j)
            }
        }
    }
    return Pair(-1, -1)
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
