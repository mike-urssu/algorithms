package tags.implementation

/**
 * https://www.acmicpc.net/problem/20299
 */
fun main() {
    val (n, k, l) = readln().split(" ").map { it.toInt() }
    val codeForceRatings = Array(n) {
        val (x1, x2, x3) = readln().split(" ").map { it.toInt() }
        intArrayOf(x1, x2, x3)
    }

    val teams = codeForceRatings.filter { ratings -> ratings.all { it >= l } && ratings.sum() >= k }
    println(teams.size)
    println(teams.flatMap { it.toList() }.joinToString(" "))
}
