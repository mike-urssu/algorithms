package tags.implementation

/**
 * https://www.acmicpc.net/problem/13597
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val c = if (a == b) {
        a
    } else {
        a.coerceAtLeast(b)
    }
    println(c)
}
