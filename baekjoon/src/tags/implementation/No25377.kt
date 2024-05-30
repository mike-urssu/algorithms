package tags.implementation

/**
 * https://www.acmicpc.net/problem/25377
 */
fun main() {
    val n = readln().toInt()
    var min = Int.MAX_VALUE
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a <= b) {
            min = min.coerceAtMost(b)
        }
    }
    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
    }
}
