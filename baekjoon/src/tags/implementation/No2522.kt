package tags.implementation

/**
 * https://www.acmicpc.net/problem/2522
 */
fun main() {
    val n = readln().toInt()
    (1 until n).forEach { i -> println("${" ".repeat(n - i)}${"*".repeat(i)}") }
    println("*".repeat(n))
    (n - 1 downTo 1).forEach { i -> println("${" ".repeat(n - i)}${"*".repeat(i)}") }
}
