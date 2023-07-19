package tags.sorting

/**
 * https://www.acmicpc.net/problem/2012
 */
import kotlin.math.absoluteValue

fun main() {
    val n = readln().toInt()
    val expectedRanks = LongArray(n) { readln().toLong() }.sortedArray()
    val sum = expectedRanks
        .mapIndexed { i, rank -> (i + 1 - rank).absoluteValue }
        .sum()
    println(sum)
}
