package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1440
 */
fun main() {
    val dates = readln().split(":").map { it.toInt() }
    var count = 0
    count += validateDates(dates[0], dates[1], dates[2])
    count += validateDates(dates[0], dates[2], dates[1])
    count += validateDates(dates[1], dates[2], dates[0])
    count += validateDates(dates[1], dates[0], dates[2])
    count += validateDates(dates[2], dates[0], dates[1])
    count += validateDates(dates[2], dates[0], dates[1])
    println(count)
}

private fun validateDates(h: Int, m: Int, s: Int): Int {
    return if (h in 1..12 && m in 0..59 && s in 0..59) {
        1
    } else {
        0
    }
}
