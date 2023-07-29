package tags.greedy

/**
 * https://www.acmicpc.net/problem/18310
 */
fun main() {
    val n = readln().toInt()
    val houses = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    println(houses[(n - 1) / 2])
}
