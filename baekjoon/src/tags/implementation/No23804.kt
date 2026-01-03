package tags.implementation

/**
 * https://www.acmicpc.net/problem/23804
 */
fun main() {
    val n = readln().toInt()
    val at = "@".repeat(n)
    repeat(n) { println(at.repeat(5)) }
    repeat(n * 3) { println(at) }
    repeat(n) { println(at.repeat(5)) }
}
