package tags.math

/**
 * https://www.acmicpc.net/problem/32498
 */
fun main() {
    val n = readln().toInt()
    val ratings = IntArray(n) { readln().toInt() }
    println(ratings.count { it % 2 == 1 })
}
