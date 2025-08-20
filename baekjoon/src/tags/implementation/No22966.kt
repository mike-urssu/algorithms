package tags.implementation

/**
 * https://www.acmicpc.net/problem/22966
 */
fun main() {
    val n = readln().toInt()
    val input = Array(n) {
        val input = readln().split(" ")
        input[0] to input[1].toInt()
    }.sortedBy { it.second }
    println(input[0].first)
}
