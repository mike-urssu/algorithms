package tags.math

/**
 * https://www.acmicpc.net/problem/34052
 */
fun main() {
    val seconds = IntArray(4) { readln().toInt() }
    if (seconds.sum() + 300 <= 1800) {
        println("Yes")
    } else {
        println("No")
    }
}
