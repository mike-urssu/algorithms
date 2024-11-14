package tags.math

/**
 * https://www.acmicpc.net/problem/4435
 */
fun main() {
    val scores1 = intArrayOf(1, 2, 3, 3, 4, 10)
    val scores2 = intArrayOf(1, 2, 2, 2, 3, 5, 10)
    val t = readln().toInt()
    repeat(t) { i ->
        val army1 = readln().split(" ").map { it.toInt() }.toIntArray()
        val army2 = readln().split(" ").map { it.toInt() }.toIntArray()
        val sum1 = sum(scores1, army1)
        val sum2 = sum(scores2, army2)
        val message = if (sum1 > sum2) {
            "Good triumphs over Evil"
        } else if (sum1 == sum2) {
            "No victor on this battle field"
        } else {
            "Evil eradicates all trace of Good"
        }
        println("Battle ${i + 1}: $message")
    }
}

private fun sum(scores: IntArray, army: IntArray) =
    army.mapIndexed { i, v -> scores[i] * v }.sum()
