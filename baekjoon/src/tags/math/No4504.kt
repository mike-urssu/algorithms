package tags.math

/**
 * https://www.acmicpc.net/problem/4504
 */
fun main() {
    val n = readln().toInt()
    while (true) {
        val num = readln().toInt()
        if (num == 0) {
            break
        }

        if (num % n == 0) {
            println("$num is a multiple of $n.")
        } else {
            println("$num is NOT a multiple of $n.")
        }
    }
}
