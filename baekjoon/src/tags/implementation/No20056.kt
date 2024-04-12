package tags.implementation

/**
 * https://www.acmicpc.net/problem/20056
 */
private var n = 0
private var fireBalls = mutableListOf<IntArray>()

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]

    repeat(input[1]) {
        val fireBall = readln().split(" ").map { it.toInt() }.toIntArray()
        fireBalls.add(fireBall)
    }

    repeat(input[2]) {
        moveFireBalls()
        fireBalls = divideFireBalls()
    }

    val sum = fireBalls.sumOf { it[2] }
    println(sum)
}

private fun moveFireBalls() {
    fireBalls.forEach { move(it) }
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

private fun move(fireBall: IntArray) {
    val (_, _, _, s, d) = fireBall
    repeat(s) {
        fireBall[0] += dx[d]
        fireBall[1] += dy[d]

        if (fireBall[0] == 0) {
            fireBall[0] = n
        } else if (fireBall[0] == n + 1) {
            fireBall[0] = 1
        }

        if (fireBall[1] == 0) {
            fireBall[1] = n
        } else if (fireBall[1] == n + 1) {
            fireBall[1] = 1
        }
    }
}

private fun divideFireBalls(): MutableList<IntArray> {
    return fireBalls
        .groupBy {
            val (r, c) = it.take(2)
            r to c
        }
        .flatMap { (it, list) ->
            if (list.size >= 2) {
                val (r, c) = it
                val m = list.sumOf { it[2] } / 5
                val s = list.sumOf { it[3] } / list.size
                val directions = if (list.all { it[4] % 2 == 1 } || list.all { it[4] % 2 == 0 }) {
                    intArrayOf(0, 2, 4, 6)
                } else {
                    intArrayOf(1, 3, 5, 7)
                }

                if (m > 0) {
                    directions.map { d -> intArrayOf(r, c, m, s, d) }
                } else {
                    emptyList()
                }
            } else {
                list
            }
        }
        .toMutableList()
}
