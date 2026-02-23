package tags.greedy

/**
 * https://www.acmicpc.net/problem/20186
 */
fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(numbers.sortedDescending().take(k).sum() - (k - 1) * k / 2)
}
