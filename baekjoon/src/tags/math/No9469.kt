package tags.math

/**
 * https://www.acmicpc.net/problem/9469
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, d, a, b, f) = readln().split(" ").map { it.toDouble() }
        println("${n.toInt()} ${d * f / (a + b)}")
    }
}
