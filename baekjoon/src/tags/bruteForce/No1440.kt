package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1440
 */
fun main() {
    val dates = readln().split(":").map { it.toInt() }
    if (dates.any { it > 59 }) {
        println(0)
    } else {
        println(dates.count { it in 1..12 } * 2)
    }
}
