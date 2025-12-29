package tags.math

/**
 * https://www.acmicpc.net/problem/30008
 */
fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val rankings = readln().split(" ").map { it.toInt() }.toIntArray()
    val grades = rankings.map { r ->
        val p = r * 100 / n
        val d = when (p) {
            in 0..4 -> 1
            in 5..11 -> 2
            in 12..23 -> 3
            in 24..40 -> 4
            in 41..60 -> 5
            in 61..77 -> 6
            in 78..89 -> 7
            in 90..96 -> 8
            else -> 9
        }
        d
    }
    println(grades.joinToString(" "))
}
