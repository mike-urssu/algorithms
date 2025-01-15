package tags.math

/**
 * https://www.acmicpc.net/problem/2991
 */
fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val (p, m, n) = readln().split(" ").map { it.toInt() }
    println(isAttacked(a, b, p) + isAttacked(c, d, p))
    println(isAttacked(a, b, m) + isAttacked(c, d, m))
    println(isAttacked(a, b, n) + isAttacked(c, d, n))
}

private fun isAttacked(a: Int, b: Int, k: Int): Int {
    var acc = 0
    while (true) {
        acc += a
        if (k <= acc) {
            return 1
        }
        acc += b
        if (k <= acc) {
            return 0
        }
    }
}
