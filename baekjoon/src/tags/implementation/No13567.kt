package tags.implementation

/**
 * https://www.acmicpc.net/problem/13567
 */
private var m = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    val n = input[1]
    val commands = Array(n) {
        val (a, b) = readln().split(" ")
        a to b.toInt()
    }

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var x = 0
    var y = 0
    var d = 0
    var isValid = true
    repeat(n) {
        val (a, b) = commands[it]
        if (a == "MOVE") {
            x += dx[d] * b
            y += dy[d] * b
            if (!isInBoundary(x, y)) {
                isValid = false
            }
        } else {
            d = if (b == 0) {
                (d + 1) % 4
            } else {
                (d + 3) % 4
            }
        }
    }

    if (isValid) {
        println("$x $y")
    } else {
        println(-1)
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0..m && y in 0..m
