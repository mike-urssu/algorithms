package tags.sorting

/**
 * https://www.acmicpc.net/problem/17263
 */
fun main() {
    readln()
    println(readln().split(" ").map { it.toInt() }.sorted().last())
}
