package tags.implementation

/**
 * https://www.acmicpc.net/problem/24267
 */
fun main() {
    val n = readln().toLong()
    val count = (1..n - 2).runningFold(0L, Long::plus).sum()
    println(count)
    println(3)
}
