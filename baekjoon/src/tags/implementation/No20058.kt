package tags.implementation

/**
 * https://www.acmicpc.net/problem/20058
 */
private var size = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val n = readln().split(" ")[0].toInt()
    size = 1 shl n
    graph = Array(size) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val units = readln().split(" ").map { 1 shl it.toInt() }
    units.forEach { fireStorm(it) }

    val sum = graph.sumOf { it.sum() }
    println(sum)
    println(maxCount())
}

private fun fireStorm(unit: Int) {
    rotateClockwise(unit)
    melt()
}

private fun rotateClockwise(unit: Int) {
    (0 until size / unit).forEach { x ->
        (0 until size / unit).forEach { y ->
            rotate(x * unit, y * unit, unit)
        }
    }
}

private fun rotate(row: Int, col: Int, unit: Int) {
    val lastIndex = unit - 1
    (0 until unit / 2).forEach { depth ->
        val temp = IntArray(unit - 1 - depth * 2) { j -> graph[row + depth][col + depth + j] }

        (lastIndex - 1 - depth downTo depth).forEach { j ->
            graph[row + depth][col + j] = graph[row + lastIndex - j][col + depth]
        }

        (depth + 1..lastIndex - depth).forEach { i ->
            graph[row + i][col + depth] = graph[row + lastIndex - depth][col + i]
        }

        (depth + 1..lastIndex - depth).forEach { j ->
            graph[row + lastIndex - depth][col + j] = graph[row + lastIndex - j][col + lastIndex - depth]
        }

        temp.forEachIndexed { i, v ->
            graph[row + depth + i][col + lastIndex - depth] = v
        }
    }
}

private fun melt() {
    val isMelted = isMelted()
    (0 until size).forEach { x ->
        (0 until size).forEach { y ->
            if (isMelted[x][y]) {
                graph[x][y]--
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isMelted(): Array<BooleanArray> {
    val isMelted = Array(size) { BooleanArray(size) }
    (0 until size).forEach { x ->
        (0 until size).forEach { y ->
            if (graph[x][y] > 0) {
                val count = (0 until 4).count { k ->
                    val nextX = x + dx[k]
                    val nextY = y + dy[k]
                    isInBoundary(nextX, nextY) && graph[nextX][nextY] > 0
                }

                if (count < 3) {
                    isMelted[x][y] = true
                }
            }
        }
    }
    return isMelted
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until size && y in 0 until size

private var count = 0

private lateinit var isVisited: Array<BooleanArray>

private fun maxCount(): Int {
    var maxCount = 0
    isVisited = Array(size) { BooleanArray(size) }
    (0 until size).forEach { x ->
        (0 until size).forEach { y ->
            if (graph[x][y] != 0 && !isVisited[x][y]) {
                count = 1
                isVisited[x][y] = true
                connect(x, y)
                maxCount = maxCount.coerceAtLeast(count)
            }
        }
    }
    return maxCount
}

private fun connect(x: Int, y: Int) {
    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] > 0) {
            count++
            isVisited[nextX][nextY] = true
            connect(nextX, nextY)
        }
    }
}
