package tags.math

/**
 * https://www.acmicpc.net/problem/5717
 */
fun main() {
    while (true) {
        val (m, f) = readln().split(" ").map { it.toInt() }
        if (m == 0 && f == 0) {
            break
        }
        println(m + f)
    }
}
