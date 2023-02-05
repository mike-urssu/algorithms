package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5576
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    writer.write("${getScore(reader)} ${getScore(reader)}")
    writer.flush()
}

private fun getScore(reader: BufferedReader): Int {
    val scores = IntArray(10)
    for (i in 0 until 10)
        scores[i] = reader.readLine().toInt()
    scores.sortDescending()

    var sum = 0
    for (i in 0 until 3)
        sum += scores[i]
    return sum
}
