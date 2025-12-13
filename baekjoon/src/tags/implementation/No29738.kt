package tags.implementation

/**
 * https://www.acmicpc.net/problem/29738
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val round = if (n > 4500) {
            "Round 1"
        } else if (n > 1000) {
            "Round 2"
        } else if (n > 25) {
            "Round 3"
        } else {
            "World Finals"
        }
        println("Case #${it + 1}: $round")
    }
}
