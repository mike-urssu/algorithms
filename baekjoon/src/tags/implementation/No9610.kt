package tags.implementation

/**
 * https://www.acmicpc.net/problem/9610
 */
fun main() {
    val quadrant = IntArray(5)
    val n = readln().toInt()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        quadrant[getQuadrant(x, y)]++
    }
    (1..4).forEach { i -> println("Q$i: ${quadrant[i]}") }
    println("AXIS: ${quadrant[0]}")
}

private fun getQuadrant(x: Int, y: Int): Int {
    if (x == 0 || y == 0) {
        return 0
    }
    return if (x > 0) {
        if (y > 0) {
            1
        } else {
            4
        }
    } else {
        if (y > 0) {
            2
        } else {
            3
        }
    }
}
