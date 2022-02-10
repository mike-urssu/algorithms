package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet

/**
 * https://www.acmicpc.net/problem/2822
 */

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val scores = IntArray(8)
    val queue = PriorityQueue<Int> { it, other -> -it.compareTo(other) }
    for (i in scores.indices) {
        val score = reader.readLine().toInt()
        scores[i] = score
        queue.add(score)
    }

    var sum = 0
    val highestScores = HashSet<Int>()
    for (i in 0 until 5) {
        val score = queue.poll()
        highestScores.add(score)
        sum += score
    }

    writer.write(sum.toString())
    writer.newLine()
    for (score in scores) {
        if (highestScores.contains(score))
            writer.write("${scores.indexOf(score) + 1} ")
    }
    writer.flush()
}
