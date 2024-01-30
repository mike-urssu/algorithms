package tags.geometry

/**
 * https://www.acmicpc.net/problem/16486
 */
private const val PI = 3.141592

fun main() {
    val d1 = readln().toInt()
    val d2 = readln().toInt()
    println(d1 * 2 + 2 * PI * d2)
}
