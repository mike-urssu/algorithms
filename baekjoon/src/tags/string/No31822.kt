package tags.string

/**
 * https://www.acmicpc.net/problem/31822
 */
fun main() {
    val code = readln().substring(0, 5)
    val n = readln().toInt()
    val codes = Array(n) { readln() }
    println(codes.count { it.substring(0, 5) == code })
}
