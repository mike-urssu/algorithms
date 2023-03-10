package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1049
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ').map { it.toInt() }
    val brokenLine = numbers[0]
    val numberOfInput = numbers[1]

    val sixLineCosts = IntArray(numberOfInput)
    val oneLineCosts = IntArray(numberOfInput)

    for (i in 0 until numberOfInput) {
        val cost = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        sixLineCosts[i] = cost[0]
        oneLineCosts[i] = cost[1]
    }
    sixLineCosts.sort()
    oneLineCosts.sort()

    writer.write(
        getMinimumCost(
            brokenLine,
            sixLineCosts[0].coerceAtMost(oneLineCosts[0] * 6),
            oneLineCosts[0]
        ).toString()
    )
    writer.flush()
}

private fun getMinimumCost(brokenLine: Int, sixLineCost: Int, oneLineCost: Int): Int {
    var cost = brokenLine / 6 * sixLineCost
    if (brokenLine % 6 != 0)
        cost += sixLineCost.coerceAtMost((brokenLine % 6) * oneLineCost)
    return cost
}
