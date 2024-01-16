package tags.math

/**
 * https://www.acmicpc.net/problem/2476
 */
fun main() {
    val n = readln().toInt()
    val max = (0 until n).maxOf {
        val dices = readln().split(" ").map { it.toInt() }
        getPrice(dices)
    }
    println(max)
}

private fun getPrice(dices: List<Int>): Int {
    val (d1, d2, d3) = dices
    return if (d1 == d2 && d2 == d3) {
        10000 + d1 * 1000
    } else if (d1 == d2) {
        1000 + d1 * 100
    } else if (d2 == d3) {
        1000 + d2 * 100
    } else if (d3 == d1) {
        1000 + d3 * 100
    } else {
        dices.max() * 100
    }
}
