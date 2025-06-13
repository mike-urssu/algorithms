package tags.math

/**
 * https://www.acmicpc.net/problem/29163
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val evens = numbers.count { it % 2 == 0 }
    if (evens > n - evens) {
        println("Happy")
    } else {
        println("Sad")
    }
}
