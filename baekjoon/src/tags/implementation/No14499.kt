package tags.implementation

/**
 * https://www.acmicpc.net/problem/14499
 */
private lateinit var graph: Array<IntArray>
private var n = 0
private var m = 0
private var x = 0
private var y = 0
private val dice = IntArray(6)

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    x = input[2]
    y = input[3]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val commands = readln().split(" ").map { it.toInt() }

    commands.forEach {
        when (it) {
            1 -> {
                if (isInBoundary(x, y + 1)) {
                    rollEast(x, y + 1)
                    y++
                    println(dice[0])
                }
            }

            2 -> {
                if (isInBoundary(x, y - 1)) {
                    rollWest(x, y - 1)
                    y--
                    println(dice[0])
                }
            }

            3 -> {
                if (isInBoundary(x - 1, y)) {
                    rollNorth(x - 1, y)
                    x--
                    println(dice[0])
                }
            }

            4 -> {
                if (isInBoundary(x + 1, y)) {
                    rollSouth(x + 1, y)
                    x++
                    println(dice[0])
                }
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun rollEast(x: Int, y: Int) {
    if (graph[x][y] == 0) {
        graph[x][y] = dice[5]

        val temp = dice[0]
        dice[0] = dice[4]
        dice[4] = dice[2]
        dice[2] = dice[5]
        dice[5] = temp
    } else {
        dice[5] = dice[0]
        dice[0] = dice[4]
        dice[4] = dice[2]
        dice[2] = graph[x][y]
        graph[x][y] = 0
    }
}

private fun rollWest(x: Int, y: Int) {
    if (graph[x][y] == 0) {
        graph[x][y] = dice[4]

        val temp = dice[0]
        dice[0] = dice[5]
        dice[5] = dice[2]
        dice[2] = dice[4]
        dice[4] = temp
    } else {
        dice[4] = dice[0]
        dice[0] = dice[5]
        dice[5] = dice[2]
        dice[2] = graph[x][y]
        graph[x][y] = 0
    }
}

private fun rollSouth(x: Int, y: Int) {
    if (graph[x][y] == 0) {
        graph[x][y] = dice[1]

        val temp = dice[0]
        dice[0] = dice[3]
        dice[3] = dice[2]
        dice[2] = dice[1]
        dice[1] = temp
    } else {
        dice[1] = dice[0]
        dice[0] = dice[3]
        dice[3] = dice[2]
        dice[2] = graph[x][y]
        graph[x][y] = 0
    }
}

private fun rollNorth(x: Int, y: Int) {
    if (graph[x][y] == 0) {
        graph[x][y] = dice[3]

        val temp = dice[0]
        dice[0] = dice[1]
        dice[1] = dice[2]
        dice[2] = dice[3]
        dice[3] = temp
    } else {
        dice[3] = dice[0]
        dice[0] = dice[1]
        dice[1] = dice[2]
        dice[2] = graph[x][y]
        graph[x][y] = 0
    }
}
