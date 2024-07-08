package tags.math

/**
 * https://www.acmicpc.net/problem/7572
 */
fun main() {
    val n = readln().toInt()
    val index1 = (n + 8) % 12
    val index2 = (n + 6) % 10
    println("${"ABCDEFGHIJKL"[index1]}${"0123456789"[index2]}")
}
