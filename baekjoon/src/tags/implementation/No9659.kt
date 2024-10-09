package tags.implementation

/**
 * https://www.acmicpc.net/problem/9659
 */
fun main() {
    val n = readln().toLong()
    val winner = if (n % 2 == 1L) {
        "SK"
    } else {
        "CY"
    }
    println(winner)
}
