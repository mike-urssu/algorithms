package tags.math

/**
 * https://www.acmicpc.net/problem/9295
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n1, n2) = readln().split(" ").map { it.toInt() }
        println("Case ${it + 1}: ${n1 + n2}")
    }
}
