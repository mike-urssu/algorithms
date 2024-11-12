package tags.implementation

/**
 * https://www.acmicpc.net/problem/9658
 */
fun main() {
    val n = readln().toInt() % 7
    val winner = if (n == 1 || n == 3) {
        "CY"
    } else {
        "SK"
    }
    println(winner)
}
