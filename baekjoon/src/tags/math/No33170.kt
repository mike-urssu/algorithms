package tags.math

/**
 * https://www.acmicpc.net/problem/33170
 */
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val v = if (a + b + c <= 21) {
        1
    } else {
        0
    }
    println(v)
}
