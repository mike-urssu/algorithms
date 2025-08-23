package tags.math

/**
 * https://www.acmicpc.net/problem/27960
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val c = a xor b
    println(c)
}
