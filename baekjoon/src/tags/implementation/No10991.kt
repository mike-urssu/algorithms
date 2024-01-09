package tags.implementation

/**
 * https://www.acmicpc.net/problem/10991
 */
fun main() {
    val n = readln().toInt()
    (1..n).forEach { i -> println("${" ".repeat(n - i)}*${" *".repeat(i - 1)}") }
}
