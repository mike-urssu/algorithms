package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2822
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val scores = IntArray(8)
    for (i in scores.indices) {
        val score = reader.readLine().toInt()
        scores[i] = score
    }

    val highestScores = scores.sortedArrayDescending().copyOf(5)

    val indices = IntArray(5)
    var index = 0
    for (i in scores.indices) {
        val score = scores[i]
        for (j in 0 until 5) {
            val highestScore = highestScores[j]
            if (score == highestScore) {
                indices[index++] = i + 1
                break
            }
        }
    }

    writer.write(highestScores.sum().toString())
    writer.newLine()
    for (i in indices)
        writer.write("$i ")
    writer.flush()
}

/*
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
*/