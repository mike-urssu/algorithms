package tags.math

/**
 * https://www.acmicpc.net/problem/28113
 */
fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    val ride = if (n > b) {
        "Bus"
    } else if (a < b) {
        "Bus"
    } else if (a == b) {
        "Anything"
    } else {
        "Subway"
    }
    println(ride)
}
