package tags.math

/**
 * https://www.acmicpc.net/problem/10178
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (c, v) = readln().split(" ").map { it.toInt() }
        println("You get ${c / v} piece(s) and your dad gets ${c % v} piece(s).")
    }
}
