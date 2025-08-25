package tags.math

/**
 * https://www.acmicpc.net/problem/12833
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val xor = if (c % 2 == 0) {
        a
    } else {
        a xor b
    }
    println(xor)
}
