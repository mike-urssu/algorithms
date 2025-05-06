package tags.math

/**
 * https://www.acmicpc.net/problem/14173
 */
fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toInt() }
    val minX = minOf(x1, x3)
    val minY = minOf(y1, y3)
    val maxX = maxOf(x2, x4)
    val maxY = maxOf(y2, y4)
    val length = maxOf(maxX - minX, maxY - minY)
    println(length * length)
}
