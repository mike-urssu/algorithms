package tags.greedy

/**
 * https://www.acmicpc.net/problem/25644
 */
fun main() {
    val n = readln().toInt()
    val stocks = readln().split(" ").map { it.toInt() }.toIntArray()

    var min = stocks[0]
    var max = 0
    for (i in 1 until n) {
        max = maxOf(max, stocks[i] - min)
        min = minOf(min, stocks[i])
    }
    println(max)
}
