package tags.implementation

/**
 * https://www.acmicpc.net/problem/23811
 */
fun main() {
    val n = readln().toInt()
    val at = "@".repeat(n)
    repeat(n) { println(at.repeat(5)) }
    repeat(n) { println(at) }
    repeat(n) { println(at.repeat(5)) }
    repeat(n) { println(at) }
    repeat(n) { println(at.repeat(5)) }
}
