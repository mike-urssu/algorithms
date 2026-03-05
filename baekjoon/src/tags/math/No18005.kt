package tags.math

/**
 * https://www.acmicpc.net/problem/18005
 */
fun main() {
    val n = readln().toLong()
    val v = if (n % 2 == 1L) {
        0
    } else if (n % 4 == 0L) {
        2
    } else {
        1
    }
    println(v)
}
