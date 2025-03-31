package tags.greedy

/**
 * https://www.acmicpc.net/problem/17615
 */
fun main() {
    val n = readln().toInt()
    val balls = readln().toCharArray()

    val min = minOf(
        toLeft(n, balls, 'R'),
        toLeft(n, balls, 'B'),
        toRight(n, balls, 'R'),
        toRight(n, balls, 'B')
    )
    println(min)
}

private fun toLeft(n: Int, balls: CharArray, color: Char): Int {
    var count = 0
    var isSameColor = balls.first() == color
    (0 until n).forEach { i ->
        if (balls[i] == color) {
            if (!isSameColor) {
                count++
            }
        } else {
            isSameColor = false
        }
    }
    return count
}

private fun toRight(n: Int, balls: CharArray, color: Char): Int {
    var count = 0
    var isSameColor = balls.last() == color
    (n - 1 downTo 0).forEach { i ->
        if (balls[i] == color) {
            if (!isSameColor) {
                count++
            }
        } else {
            isSameColor = false
        }
    }
    return count
}
