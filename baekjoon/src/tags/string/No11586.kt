package tags.string

/**
 * https://www.acmicpc.net/problem/11586
 */
fun main() {
    val n = readln().toInt()
    val mirror = Array(n) { readln() }
    val k = readln().toInt()
    when (k) {
        1 -> mirror.forEach { println(it) }
        2 -> mirror.forEach { println(it.reversed()) }
        3 -> mirror.reversed().forEach { println(it) }
    }
}
