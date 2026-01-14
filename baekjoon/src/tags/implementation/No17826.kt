package tags.implementation

/**
 * https://www.acmicpc.net/problem/17826
 */
fun main() {
    val scores = readln().split(" ").map { it.toInt() }.toIntArray()
    val score = readln().toInt()
    val index = scores.indexOf(score) + 1
    val grade = when (index) {
        in 1..5 -> "A+"
        in 6..15 -> "A0"
        in 16..30 -> "B+"
        in 31..35 -> "B0"
        in 36..45 -> "C+"
        in 46..48 -> "C0"
        else -> "F"
    }
    println(grade)
}
