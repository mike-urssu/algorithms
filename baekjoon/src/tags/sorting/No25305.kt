package tags.sorting

/**
 * https://www.acmicpc.net/problem/25305
 */
fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val scores = readln().split(" ").map { it.toInt() }.sortedDescending()
    println(scores[k - 1])
}
