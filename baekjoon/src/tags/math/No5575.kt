package tags.math

/**
 * https://www.acmicpc.net/problem/5575
 */
fun main() {
    repeat(3) {
        val input = readln().split(" ").map { it.toInt() }
        println(getOfficeHour(input[0], input[1], input[2], input[3], input[4], input[5]).joinToString(" "))
    }
}

private fun getOfficeHour(h1: Int, m1: Int, s1: Int, h2: Int, m2: Int, s2: Int): IntArray {
    val totalSeconds = (h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1)
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = (totalSeconds % 3600) % 60
    return intArrayOf(hours, minutes, seconds)
}
