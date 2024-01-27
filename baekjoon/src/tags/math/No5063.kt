package tags.math

/**
 * https://www.acmicpc.net/problem/5063
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (r, e, c) = readln().split(" ").map { it.toInt() }
        if (r + c < e) {
            println("advertise")
        } else if (r + c == e) {
            println("does not matter")
        } else {
            println("do not advertise")
        }
    }
}
