package tags.math

/**
 * https://www.acmicpc.net/problem/32025
 */
fun main() {
    val h = readln().toInt()
    val w = readln().toInt()
    println(minOf(w, h) * 50)
}
