package tags.sorting

/**
 * https://www.acmicpc.net/problem/18310
 */
fun main() {
    val n = readln().toInt()
    val houses = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(houses[(n - 1) / 2])
}
