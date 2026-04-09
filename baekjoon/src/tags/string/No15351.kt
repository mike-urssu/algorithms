package tags.string

/**
 * https://www.acmicpc.net/problem/15351
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val score = getScore(s)
        if (score == 100) {
            println("PERFECT LIFE")
        } else {
            println(score)
        }
    }
}

private fun getScore(s: String) =
    s.filter { it in 'A'..'Z' }.sumOf { it - 'A' + 1 }
