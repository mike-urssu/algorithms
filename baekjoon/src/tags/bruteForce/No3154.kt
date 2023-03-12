package tags.bruteForce

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/3154
 */
private val dials = listOf(
    Pair(3, 1),
    Pair(0, 0),
    Pair(0, 1),
    Pair(0, 2),
    Pair(1, 0),
    Pair(1, 1),
    Pair(1, 2),
    Pair(2, 0),
    Pair(2, 1),
    Pair(2, 2)
)

fun main() {
    val (hh, mm) = readln().split(":").map { it.toInt() }

    val minTime = IntArray(2)
    var minEffort = Int.MAX_VALUE
    var h = hh
    while (h < 100) {
        var m = mm
        while (m < 100) {
            val effort = getEffort(h, m)
            if (effort < minEffort) {
                minEffort = effort
                minTime[0] = h
                minTime[1] = m
            }
            m += 60
        }
        h += 24
    }

    println("${String.format("%02d", minTime[0])}:${String.format("%02d", minTime[1])}")
}

private fun getEffort(h: Int, m: Int) =
    effort(h / 10, h % 10) + effort(h % 10, m / 10) + effort(m / 10, m % 10)

private fun effort(from: Int, to: Int) =
    abs(dials[from].first - dials[to].first) + abs(dials[from].second - dials[to].second)
