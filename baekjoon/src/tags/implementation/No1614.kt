package tags.implementation

/**
 * https://www.acmicpc.net/problem/1614
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toLong()

    val max = if (n == 1) {
        8 * m
    } else if (n == 5) {
        4 + 8 * m
    } else if (m % 2 == 0L) {
        4 * m + n - 1
    } else {
        4 * m + 5 - n
    }
    println(max)
}
