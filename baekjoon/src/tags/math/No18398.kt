package tags.math

/**
 * https://www.acmicpc.net/problem/18398
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        repeat(n) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            println("${a + b} ${a * b}")
        }
    }
}
