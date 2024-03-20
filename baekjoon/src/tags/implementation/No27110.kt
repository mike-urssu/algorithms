package tags.implementation

/**
 * https://www.acmicpc.net/problem/27110
 */
fun main() {
    val n = readln().toInt()
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val p = minOf(a, n) + minOf(b, n) + minOf(c, n)
    println(p)
}
