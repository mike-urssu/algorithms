package tags.math

/**
 * https://www.acmicpc.net/problem/18247
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val seat = if (n < 12 || m < 4) {
            -1
        } else {
            m * 11 + 4
        }
        println(seat)
    }
}
