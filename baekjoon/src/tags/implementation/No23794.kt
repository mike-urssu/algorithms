package tags.implementation

/**
 * https://www.acmicpc.net/problem/23794
 */
fun main() {
    val n = readln().toInt()
    println("@".repeat(n + 2))
    repeat(n) {
        println("@${" ".repeat(n)}@")
    }
    println("@".repeat(n + 2))
}
