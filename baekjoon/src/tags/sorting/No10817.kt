package tags.sorting

/**
 * https://www.acmicpc.net/problem/10817
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    println(numbers.sorted()[1])
}
