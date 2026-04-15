package tags.math

/**
 * https://www.acmicpc.net/problem/34849
 */
fun main() {
    val n = readln().toInt()
    val s = if (n <= 10000) {
        "Accepted"
    } else {
        "Time limit exceeded"
    }
    println(s)
}
