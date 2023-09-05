package tags.bfs

/**
 * https://www.acmicpc.net/problem/13460
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<Array<Array<BooleanArray>>>

private var rx = 0
private var ry = 0
private var bx = 0
private var by = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    isVisited = Array(n) { Array(m) { Array(n) { BooleanArray(m) } } }
    setPoints()

    val count = bfs()
    println(count)
}

private fun setPoints() {
    val r = find('R')
    rx = r[0]
    ry = r[1]
    val b = find('B')
    bx = b[0]
    by = b[1]
}

private fun find(color: Char): List<Int> {
    var x = 0
    var y = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == color) {
                x = i
                y = j
            }
        }
    }
    return listOf(x, y)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(): Int {
    val queue: Queue<Triple<Pair<Int, Int>, Pair<Int, Int>, Int>> = LinkedList()

    isVisited[rx][ry][bx][by] = true
    queue.add(Triple(Pair(rx, ry), Pair(bx, by), 0))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val r = p.first
        val b = p.second
        val count = p.third

        if (count > 10) {
            return -1
        }

        if (graph[r.first][r.second] == 'O') {
            return count
        }

        for (i in 0 until 4) {
            move('R', r, i)
            move('B', b, i)
            if (graph[bx][by] == 'O') {
                continue
            }
            if (rx == bx && ry == by) {
                moveBack(r, b, i)
            }

            if (!isVisited[rx][ry][bx][by]) {
                isVisited[rx][ry][bx][by] = true
                queue.add(Triple(Pair(rx, ry), Pair(bx, by), count + 1))
            }
        }
    }

    return -1
}

private fun move(color: Char, p: Pair<Int, Int>, i: Int) {
    var x = p.first
    var y = p.second

    when (i) {
        0, 2 -> {
            while (graph[x + dx[i]][y] != '#') {
                x += dx[i]
                if (graph[x][y] == 'O') {
                    break
                }
            }
        }

        1, 3 -> {
            while (graph[x][y + dy[i]] != '#') {
                y += dy[i]
                if (graph[x][y] == 'O') {
                    break
                }
            }
        }
    }

    if (color == 'R') {
        rx = x
        ry = y
    } else {
        bx = x
        by = y
    }
}

private fun moveBack(r: Pair<Int, Int>, b: Pair<Int, Int>, i: Int) {
    when (i) {
        0 -> {
            if (r.first < b.first) {
                bx++
            } else {
                rx++
            }
        }

        1 -> {
            if (r.second < b.second) {
                ry--
            } else {
                by--
            }
        }

        2 -> {
            if (r.first < b.first) {
                rx--
            } else {
                bx--
            }
        }

        3 -> {
            if (r.second < b.second) {
                by++
            } else {
                ry++
            }
        }
    }
}
