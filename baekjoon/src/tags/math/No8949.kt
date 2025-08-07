package tags.math

/**
 * https://www.acmicpc.net/problem/8949
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.reversed() }.sortedBy { it.toInt() }
    val sum = StringBuilder()
    a.indices.forEach { i -> sum.append("${a[i].digitToInt() + b[i].digitToInt()}".reversed()) }
    (a.lastIndex + 1 until b.length).forEach { i -> sum.append("${b[i].digitToInt()}".reversed()) }
    println(sum.reversed())
}
