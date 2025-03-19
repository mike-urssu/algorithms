package tags.math

/**
 * https://www.acmicpc.net/problem/27219
 */
fun main() {
    val n = readln().toInt()
    println("${"V".repeat(n / 5)}${"I".repeat(n % 5)}")
}
