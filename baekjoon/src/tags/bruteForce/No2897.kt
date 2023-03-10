package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2897
 */
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val beach = Array(r) { readln().toCharArray() }
    IntArray(5) { countBreakableCars(beach, r, c, it) }
        .forEach { println(it) }
}

private fun countBreakableCars(beach: Array<CharArray>, row: Int, col: Int, breakableCars: Int): Int {
    var count = 0
    for (i in 0..row - 2) {
        for (j in 0..col - 2) {
            val cars = listOf(beach[i][j], beach[i + 1][j], beach[i][j + 1], beach[i + 1][j + 1])
            if (cars.all { it != '#' } && cars.count { it == 'X' } == breakableCars) {
                count++
            }
        }
    }
    return count
}
