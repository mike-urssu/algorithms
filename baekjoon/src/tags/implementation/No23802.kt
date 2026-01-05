package tags.implementation

/**
 * https://www.acmicpc.net/problem/23802
 */
fun main() {
    val n = readln().toInt()
    val at = "@".repeat(n)
    repeat(n) { println(at.repeat(5)) }
    repeat(n * 4) { println(at) }
}
