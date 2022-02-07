package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1946
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = reader.readLine().toInt()
    for (i in 0 until testCase) {
        val numberOfInput = reader.readLine().toInt()
        val scores = arrayListOf<List<Int>>()
        for (j in 0 until numberOfInput) {
            val score = reader.readLine().split(' ').map { it.toInt() }
            scores.add(score)
        }

        scores.sortWith(compareBy { it[0] })

        var count = 0
        var minScore = Int.MAX_VALUE
        for (j in scores.indices) {
            val score = scores[j][1]
            if (minScore > score) {
                minScore = score
                count++
            }
        }
        writer.write(count.toString())
        writer.newLine()
    }
    writer.flush()
}
