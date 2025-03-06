package tags.implementation

/**
 * https://www.acmicpc.net/problem/20125
 */
private var n = 0
private lateinit var graph: Array<CharArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }
    val (x, y) = findHeart()
    println("${x + 1} ${y + 1}")
    val wrist = wrist(x, y)
    println("${leftArm(x, y)} ${rightArm(x, y)} $wrist ${leftLeg(x + wrist, y)} ${rightLeg(x + wrist, y)}")
}

private fun findHeart(): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (isHeart(i, j)) {
                return i to j
            }
        }
    }
    return -1 to -1
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isHeart(x: Int, y: Int) =
    graph[x][y] == '*' &&
        (0 until 4).all { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            isInBoundary(nextX, nextY) && graph[nextX][nextY] == '*'
        }

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun leftArm(x: Int, y: Int): Int {
    var leftArm = 0
    for (j in y - 1 downTo 0) {
        if (graph[x][j] != '*') {
            break
        }
        leftArm++
    }
    return leftArm
}

private fun rightArm(x: Int, y: Int): Int {
    var rightArm = 0
    for (j in y + 1 until n) {
        if (graph[x][j] != '*') {
            break
        }
        rightArm++
    }
    return rightArm
}

private fun wrist(x: Int, y: Int): Int {
    var wrist = 0
    for (i in x + 1 until n) {
        if (graph[i][y] != '*') {
            break
        }
        wrist++
    }
    return wrist
}

private fun leftLeg(x: Int, y: Int): Int {
    var leftLeg = 0
    for (i in x + 1 until n) {
        if (graph[i][y - 1] != '*') {
            break
        }
        leftLeg++
    }
    return leftLeg
}

private fun rightLeg(x: Int, y: Int): Int {
    var rightLeg = 0
    for (i in x + 1 until n) {
        if (graph[i][y + 1] != '*') {
            break
        }
        rightLeg++
    }
    return rightLeg
}
