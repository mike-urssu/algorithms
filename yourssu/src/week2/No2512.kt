package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2512
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val requests = reader.readLine().split(" ").map { it.toInt() }
    val budget = reader.readLine().toInt()
    if (requests.sum() <= budget)
        writer.write("${requests.sortedDescending()[0]}")
    else
        writer.write("${getUpperLimit(requests, budget)}")
    writer.flush()
}

private fun getUpperLimit(requests: List<Int>, budget: Int): Int {
    var low = 0
    var high = 1000000000 + 1

    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (requests.sumOf { (it.coerceAtMost(mid)) } > budget)
            high = mid
        else
            low = mid
    }

    return low
}