package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1292
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (from, to) = reader.readLine().split(" ").map { it.toInt() }
    val accSum = getAccSum(to)
    writer.write("${accSum.asList().subList(from - 1, to).sum()}")
    writer.flush()
}

private fun getAccSum(length: Int): IntArray {
    val accSum = IntArray(length)
    var count = 1
    var number = 1
    for (i in 0 until length) {
        if (count == 0) {
            number++
            count = number
        }
        accSum[i] = number
        count--
    }
    return accSum
}
