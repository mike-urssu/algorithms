package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2847
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val scores = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        scores[i] = reader.readLine().toInt()

    writer.write(getReducedScore(scores.reversedArray()).toString())
    writer.flush()
}

private fun getReducedScore(scores: IntArray): Int {
    var reducedScore = 0
    var highestScore = scores[0]
    for (i in 1 until scores.size) {
        if (scores[i] >= highestScore) {
            highestScore--
            reducedScore += scores[i] - highestScore
        } else {
            highestScore = scores[i]
        }
    }
    return reducedScore
}
