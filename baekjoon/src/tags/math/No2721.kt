package tags.math

/**
 * https://www.acmicpc.net/problem/2721
 */
fun main() {
    val t = readln().toInt()
    val arrayT = (1..301).runningFold(0, Int::plus)
    repeat(t) {
        val n = readln().toInt()
        val w = (1..n).sumOf { k -> k * arrayT[k + 1] }
        println(w)
    }
}
