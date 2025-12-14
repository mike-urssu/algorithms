package tags.implementation

/**
 * https://www.acmicpc.net/problem/29725
 */
private val scores = mapOf(
    '.' to 0,
    'K' to 0,
    'k' to 0,
    'P' to 1,
    'p' to -1,
    'N' to 3,
    'n' to -3,
    'B' to 3,
    'b' to -3,
    'R' to 5,
    'r' to -5,
    'Q' to 9,
    'q' to -9,
)

fun main() {
    val board = Array(8) { readln().toCharArray() }
    val sum = board.sumOf { it.sumOf { scores[it]!! } }
    println(sum)
}
