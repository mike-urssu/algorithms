package tags.math

/**
 * https://www.acmicpc.net/problem/24079
 */
fun main() {
    val x = readln().toInt()
    val y = readln().toInt()
    val z = readln().toInt()
    val v = if ((x + y) * 60 <= z * 60 + 30) {
        1
    } else {
        0
    }
    println(v)
}
