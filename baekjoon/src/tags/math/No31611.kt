package tags.math

/**
 * https://www.acmicpc.net/problem/31611
 */
fun main() {
    val x = readln().toInt()
    val isTuesday = if (x % 7 == 2) {
        1
    } else {
        0
    }
    println(isTuesday)
}
