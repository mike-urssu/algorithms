package tags.implementation

/**
 * https://www.acmicpc.net/problem/23806
 */
fun main() {
    val n = readln().toInt()
    val at = "@".repeat(n)
    val space = " ".repeat(n)
    repeat(n) { println(at.repeat(5)) }
    repeat(n * 3) { println(at + space.repeat(3) + at) }
    repeat(n) { println(at.repeat(5)) }
}
