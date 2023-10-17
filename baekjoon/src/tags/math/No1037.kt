package tags.math

/**
 * https://www.acmicpc.net/problem/1037
 */
fun main() {
    readln()
    val factors = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(factors.first() * factors.last())
}
