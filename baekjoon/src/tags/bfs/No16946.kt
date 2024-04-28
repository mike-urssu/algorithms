package tags.bfs

/**
 * https://www.acmicpc.net/problem/16946
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var group: Array<IntArray>
private val numbers = IntArray(500001)

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(m) }
    setGroup()

    val counts = getCounts()
    counts.forEach { println(it.joinToString("")) }
}

private fun setGroup() {
    group = Array(n) { IntArray(m) }
    var num = 1
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (!isVisited[i][j]) {
                if (graph[i][j] == 1) {
                    isVisited[i][j] = true
                } else {
                    isVisited[i][j] = true
                    group[i][j] = num
                    numbers[num]++
                    bfs(i, j, num)
                    num++
                }
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun bfs(x: Int, y: Int, num: Int) {
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
            isVisited[nextX][nextY] = true
            group[nextX][nextY] = num
            numbers[num]++
            bfs(nextX, nextY, num)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun getCounts(): Array<IntArray> {
    val counts = Array(n) { IntArray(m) }
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (group[i][j] == 0) {
                val set = mutableSetOf<Int>()
                (0 until 4).forEach { k ->
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY)) {
                        set.add(group[nextX][nextY])
                    }
                }
                counts[i][j] = (set.sumOf { numbers[it] } + 1) % 10
            }
        }
    }
    return counts
}
