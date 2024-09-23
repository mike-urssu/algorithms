package tags.sorting

/**
 * https://www.acmicpc.net/problem/16212
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    println(numbers.joinToString(" "))
}
