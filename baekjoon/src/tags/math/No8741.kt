package tags.math

/**
 * https://www.acmicpc.net/problem/8741
 */
fun main() {
    val k = readln().toInt()
    println("${"1".repeat(k)}${"0".repeat(k - 1)}")
}
