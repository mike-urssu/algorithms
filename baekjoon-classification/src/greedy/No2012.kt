package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/2012
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val rankings = IntArray(numberOfInput)
    for (i in rankings.indices)
        rankings[i] = reader.readLine().toInt()
    rankings.sort()

    var sum = 0L
    for (i in rankings.indices)
        sum += abs(rankings[i] - (i + 1))

    writer.write(sum.toString())
    writer.flush()
}
