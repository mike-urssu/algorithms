package tags.math

/**
 * https://www.acmicpc.net/problem/24736
 */
fun main() {
    repeat(2) {
        val (t, f, s, p, c) = readln().split(" ").map { it.toInt() }
        println(t * 6 + f * 3 + s * 2 + p + c * 2)
    }
}
