package tags.math

/**
 * https://www.acmicpc.net/problem/25600
 */
fun main() {
    val n = readln().toInt()
    val scores = Array(n) { readln().split(" ").map { it.toInt() } }
        .map { (a, d, g) ->
            var score = a * (d + g)
            if (a == d + g) {
                score *= 2
            }
            score
        }
    println(scores.max())
}
