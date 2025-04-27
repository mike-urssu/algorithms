package tags.implementation

/**
 * https://www.acmicpc.net/problem/13623
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val winner = if (a == b && b == c) {
        "*"
    } else {
        if (a == b) {
            "C"
        } else if (b == c) {
            "A"
        } else {
            "B"
        }
    }
    println(winner)
}
