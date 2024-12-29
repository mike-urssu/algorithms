package tags.implementation

/**
 * https://www.acmicpc.net/problem/7595
 */
fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        (1..n).forEach { i ->
            println("*".repeat(i))
        }
    }
}
