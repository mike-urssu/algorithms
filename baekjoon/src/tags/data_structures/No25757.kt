package tags.data_structures

/**
 * https://www.acmicpc.net/problem/25757
 */
fun main() {
    val input = readln().split(" ")
    val n = input[0].toInt()
    val game = input[1]

    val distinctNames = (0 until n).map { readln() }.toSet()
    val count = when (game) {
        "Y" -> distinctNames.size
        "F" -> distinctNames.size / 2
        else -> distinctNames.size / 3
    }
    println(count)
}
