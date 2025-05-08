package tags.math

/**
 * https://www.acmicpc.net/problem/20976
 */
fun main() {
    val (_, b, _) = readln().split(" ").map { it.toInt() }.sorted()
    println(b)
}
