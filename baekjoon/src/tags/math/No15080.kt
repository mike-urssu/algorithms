package tags.math

/**
 * https://www.acmicpc.net/problem/15080
 */
fun main() {
    val (hh1, mm1, ss1) = readln().split(":").map { it.trim().toInt() }
    val (hh2, mm2, ss2) = readln().split(":").map { it.trim().toInt() }
    var sum = (hh2 - hh1) * 3600 + (mm2 - mm1) * 60 + (ss2 - ss1)
    if (sum < 0) {
        sum += 24 * 3600
    }
    println(sum)
}
