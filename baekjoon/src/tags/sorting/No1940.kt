package tags.sorting

/**
 * https://www.acmicpc.net/problem/1940
 */
fun main() {
    readln()
    val m = readln().toInt()
    val stuffs = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val count = stuffs.count { stuff -> stuffs.binarySearch(m - stuff) >= 0 } / 2
    println(count)
}
