package tags.math

/**
 * https://www.acmicpc.net/problem/20233
 */
fun main() {
    val a = readln().toInt()
    val x = readln().toInt()
    val b = readln().toInt()
    val y = readln().toInt()
    val t = readln().toInt()

    val fee1 = a + maxOf(t - 30, 0) * x * 21
    val fee2 = b + maxOf(t - 45, 0) * y * 21
    println("$fee1 $fee2")
}
