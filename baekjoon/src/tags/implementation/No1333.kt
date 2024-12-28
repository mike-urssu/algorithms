package tags.implementation

/**
 * https://www.acmicpc.net/problem/1333
 */
fun main() {
    val (n, l, d) = readln().split(" ").map { it.toInt() }
    val isMusicOn = BooleanArray(3700)
    (1..n).forEach { i ->
        (0 until l).forEach { j ->
            isMusicOn[(i - 1) * 5 + (i - 1) * l + j] = true
        }
    }

    val first = (0..3600 step d).first { !isMusicOn[it] }
    println(first)
}
