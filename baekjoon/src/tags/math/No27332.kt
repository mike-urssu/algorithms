package tags.math

/**
 * https://www.acmicpc.net/problem/27332
 */
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val v = if (a + b * 7 <= 30) {
        1
    } else {
        0
    }
    println(v)
}
