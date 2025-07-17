package tags.greedy

/**
 * https://www.acmicpc.net/problem/28014
 */
fun main() {
    val n = readln().toInt()
    val heights = readln().split(" ").map { it.toInt() }.toIntArray()
    println((1 until n).count { i -> heights[i - 1] <= heights[i] } + 1)
}
