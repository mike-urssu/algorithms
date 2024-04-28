package tags.implementation

/**
 * https://www.acmicpc.net/problem/20057
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private var sum = 0

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var x = n / 2
    var y = n / 2
    var k = 1
    repeat(n / 2) {
        repeat(k) {
            moveLeft(x, --y)
        }
        repeat(k) {
            moveDown(++x, y)
        }
        k++

        repeat(k) {
            moveRight(x, ++y)
        }
        repeat(k) {
            moveUp(--x, y)
        }
        k++
    }
    repeat(k - 1) {
        moveLeft(x, --y)
    }
    println(sum)
}

private fun moveLeft(x: Int, y: Int) {
    val sand = graph[x][y]
    var removedSand = 0

    removedSand += sum(x, y - 2, sand, 0.05)

    removedSand += sum(x - 1, y - 1, sand, 0.1)
    removedSand += sum(x + 1, y - 1, sand, 0.1)

    removedSand += sum(x - 2, y, sand, 0.02)
    removedSand += sum(x - 1, y, sand, 0.07)
    removedSand += sum(x + 1, y, sand, 0.07)
    removedSand += sum(x + 2, y, sand, 0.02)

    removedSand += sum(x - 1, y + 1, sand, 0.01)
    removedSand += sum(x + 1, y + 1, sand, 0.01)

    if (isInBoundary(x, y - 1)) {
        graph[x][y - 1] += (sand - removedSand)
    } else {
        sum += (sand - removedSand)
    }

    graph[x][y] = 0
}

private fun moveDown(x: Int, y: Int) {
    val sand = graph[x][y]
    var removedSand = 0

    removedSand += sum(x + 2, y, sand, 0.05)

    removedSand += sum(x + 1, y - 1, sand, 0.1)
    removedSand += sum(x + 1, y + 1, sand, 0.1)

    removedSand += sum(x, y - 2, sand, 0.02)
    removedSand += sum(x, y - 1, sand, 0.07)
    removedSand += sum(x, y + 1, sand, 0.07)
    removedSand += sum(x, y + 2, sand, 0.02)

    removedSand += sum(x - 1, y - 1, sand, 0.01)
    removedSand += sum(x - 1, y + 1, sand, 0.01)

    if (isInBoundary(x + 1, y)) {
        graph[x + 1][y] += (sand - removedSand)
    } else {
        sum += (sand - removedSand)
    }

    graph[x][y] = 0
}

private fun moveRight(x: Int, y: Int) {
    val sand = graph[x][y]
    var removedSand = 0

    removedSand += sum(x, y + 2, sand, 0.05)

    removedSand += sum(x - 1, y + 1, sand, 0.1)
    removedSand += sum(x + 1, y + 1, sand, 0.1)

    removedSand += sum(x - 2, y, sand, 0.02)
    removedSand += sum(x - 1, y, sand, 0.07)
    removedSand += sum(x + 1, y, sand, 0.07)
    removedSand += sum(x + 2, y, sand, 0.02)

    removedSand += sum(x - 1, y - 1, sand, 0.01)
    removedSand += sum(x + 1, y - 1, sand, 0.01)

    if (isInBoundary(x, y + 1)) {
        graph[x][y + 1] += (sand - removedSand)
    } else {
        sum += (sand - removedSand)
    }

    graph[x][y] = 0
}

private fun moveUp(x: Int, y: Int) {
    val sand = graph[x][y]
    var removedSand = 0

    removedSand += sum(x - 2, y, sand, 0.05)

    removedSand += sum(x - 1, y - 1, sand, 0.1)
    removedSand += sum(x - 1, y + 1, sand, 0.1)

    removedSand += sum(x, y - 2, sand, 0.02)
    removedSand += sum(x, y - 1, sand, 0.07)
    removedSand += sum(x, y + 1, sand, 0.07)
    removedSand += sum(x, y + 2, sand, 0.02)

    removedSand += sum(x + 1, y - 1, sand, 0.01)
    removedSand += sum(x + 1, y + 1, sand, 0.01)

    if (isInBoundary(x - 1, y)) {
        graph[x - 1][y] += (sand - removedSand)
    } else {
        sum += (sand - removedSand)
    }

    graph[x][y] = 0
}

private fun sum(x: Int, y: Int, sand: Int, ratio: Double): Int {
    val v = (sand * ratio).toInt()
    if (isInBoundary(x, y)) {
        graph[x][y] += v
    } else {
        sum += v
    }
    return v
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
