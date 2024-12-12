package tags.implementation

/**
 * https://www.acmicpc.net/problem/29731
 */
fun main() {
    val promises = arrayOf(
        "Never gonna give you up",
        "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop"
    )

    val n = readln().toInt()
    val s = Array(n) { readln() }
    val isHacked = if (s.any { it !in promises }) {
        "Yes"
    } else {
        "No"
    }
    println(isHacked)
}
