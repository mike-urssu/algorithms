package tags.implementation

/**
 * https://www.acmicpc.net/problem/24313
 */
fun main() {
    val (a1, a0) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    val n0 = readln().toInt()

    if (isValid(a1, a0, c, n0)) {
        println(1)
    } else {
        println(0)
    }
}

private fun isValid(a1: Int, a0: Int, c: Int, n0: Int) =
    (n0..100).all { i -> a0 <= (c - a1) * i }
