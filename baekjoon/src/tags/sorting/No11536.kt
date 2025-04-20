package tags.sorting

/**
 * https://www.acmicpc.net/problem/11536
 */
fun main() {
    val n = readln().toInt()
    val names = Array(n) { readln() }
    val order = if (names.contentEquals(names.sortedArray())) {
        "INCREASING"
    } else if (names.contentEquals(names.sortedArrayDescending())) {
        "DECREASING"
    } else {
        "NEITHER"
    }
    println(order)
}
