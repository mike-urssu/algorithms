package tags.math

/**
 * https://www.acmicpc.net/problem/18411
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }.sortedDescending()
    println(numbers.take(2).sum())
}
