package tags.math

/**
 * https://www.acmicpc.net/problem/27890
 */
fun main() {
    val (x, n) = readln().split(" ").map { it.toInt() }
    var h = x
    repeat(n) {
        h = if (h % 2 == 0) {
            h / 2 xor 6
        } else {
            h * 2 xor 6
        }
    }
    println(h)
}
