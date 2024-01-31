package tags.implementation

/**
 * https://www.acmicpc.net/problem/10995
 */
fun main() {
    val n = readln().toInt()
    val odd = " *".repeat(n)
    val even = odd.reversed().trim()
    (0 until n).forEach {
        if (it % 2 == 0) {
            println(even)
        } else {
            println(odd)
        }
    }
}
