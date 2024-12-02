package tags.math

/**
 * https://www.acmicpc.net/problem/27324
 */
fun main() {
    val n = readln().toInt()
    if (n / 10 == n % 10) {
        println(1)
    } else {
        println(0)
    }
}
