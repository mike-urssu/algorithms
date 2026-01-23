package tags.math

/**
 * https://www.acmicpc.net/problem/24083
 */
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    var v = (a + b) % 12
    if (v == 0) {
        v = 12
    }
    println(v)
}
