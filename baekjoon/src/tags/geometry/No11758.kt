package tags.geometry

/**
 * https://www.acmicpc.net/problem/11758
 */
fun main() {
    val (x1, y1) = readln().split(" ").map { it.toInt() }
    val (x2, y2) = readln().split(" ").map { it.toInt() }
    val (x3, y3) = readln().split(" ").map { it.toInt() }
    println(getDirection(x1, y1, x2, y2, x3, y3))
}

private fun getDirection(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Int {
    val v1 = Pair(x2 - x1, y2 - y1)
    val v2 = Pair(x3 - x2, y3 - y2)

    val d = v1.first * v2.second - v1.second * v2.first
    return if (d > 0) {
        1
    } else if (d == 0) {
        0
    } else {
        -1
    }
}
