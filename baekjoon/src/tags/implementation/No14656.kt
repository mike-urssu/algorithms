package tags.implementation

/**
 * https://www.acmicpc.net/problem/14656
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val count = (1..n).count { i -> numbers[i - 1] != i }
    println(count)
}
