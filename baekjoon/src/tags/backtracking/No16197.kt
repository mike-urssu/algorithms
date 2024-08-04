package tags.backtracking

/**
 * https://www.acmicpc.net/problem/16197
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>

private lateinit var coins: List<IntArray>
private val movements = IntArray(10)

private var min = Int.MAX_VALUE

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    coins = getCoins()

    setMovements(0)

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
    }
}

private fun getCoins(): List<IntArray> {
    val coins = mutableListOf<IntArray>()
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] == 'o') {
                coins.add(intArrayOf(i, j))
            }
        }
    }
    return coins
}

private fun setMovements(index: Int) {
    if (index == 10) {
        moveCoins()
        return
    }

    (0 until 4).forEach { k ->
        movements[index] = k
        setMovements(index + 1)
    }
}

private fun moveCoins() {
    val copiedGraph = Array(n) { graph[it].copyOf() }
    val coin1 = coins[0].copyOf()
    val coin2 = coins[1].copyOf()

    var drop = 0
    (0 until 10).forEach { i ->
        drop += moveCoins(copiedGraph, coin1, coin2, movements[i])
        if (drop == 1) {
            min = min.coerceAtMost(i + 1)
            return
        } else if (drop == 2) {
            return
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun moveCoins(graph: Array<CharArray>, coin1: IntArray, coin2: IntArray, k: Int): Int {
    var drop = 0
    var isCoin2Moved = false

    if (isInBoundary(coin1[0], coin1[1])) {
        val nextX = coin1[0] + dx[k]
        val nextY = coin1[1] + dy[k]

        if (!isInBoundary(nextX, nextY)) {
            graph[coin1[0]][coin1[1]] = '.'
            coin1[0] = nextX
            coin1[1] = nextY
            drop++
        } else {
            when (graph[nextX][nextY]) {
                'o' -> {
                    val nextX2 = coin2[0] + dx[k]
                    val nextY2 = coin2[1] + dy[k]

                    if (!isInBoundary(nextX2, nextY2)) {
                        isCoin2Moved = true

                        coin2[0] = nextX2
                        coin2[1] = nextY2

                        moveCoin(graph, coin1, nextX, nextY)

                        drop++
                    } else {
                        if (graph[nextX2][nextY2] == '.') {
                            isCoin2Moved = true
                            moveCoin(graph, coin2, nextX2, nextY2)
                            moveCoin(graph, coin1, nextX, nextY)
                        }
                    }
                }

                '.' -> moveCoin(graph, coin1, nextX, nextY)
            }
        }
    }

    if (!isCoin2Moved) {
        if (isInBoundary(coin2[0], coin2[1])) {
            val nextX = coin2[0] + dx[k]
            val nextY = coin2[1] + dy[k]

            if (!isInBoundary(nextX, nextY)) {
                graph[coin2[0]][coin2[1]] = '.'
                coin2[0] = nextX
                coin2[1] = nextY
                drop++
            } else {
                if (graph[nextX][nextY] == '.') {
                    moveCoin(graph, coin2, nextX, nextY)
                }
            }
        }
    }
    return drop
}

private fun moveCoin(graph: Array<CharArray>, coin: IntArray, nextX: Int, nextY: Int) {
    graph[coin[0]][coin[1]] = '.'
    graph[nextX][nextY] = 'o'
    coin[0] = nextX
    coin[1] = nextY
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
