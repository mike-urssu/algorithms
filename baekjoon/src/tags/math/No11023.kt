package tags.math

/**
 * https://www.acmicpc.net/problem/11023
 */
fun main() {
    val sum = readln().split(" ").map { it.toInt() }.sum()
    println(sum)
}
