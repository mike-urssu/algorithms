package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/2841
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    val numberOfNote = input[0]
    val lines = Array(numberOfNote + 1) { _ ->
        PriorityQueue<Int> { it, other -> -it.compareTo(other) }
    }

    var count = 0
    repeat(numberOfNote) {
        val position = reader.readLine().split(" ").map { it.toInt() }
        val line = lines[position[0]]
        val fret = position[1]

        if (line.isEmpty() || line.peek() < fret) {
            line.add(fret)
            count++
        } else {
            while (line.isNotEmpty() && line.peek() > fret) {
                line.poll()
                count++
            }

            if (line.peek() != fret) {
                line.add(fret)
                count++
            }
        }
    }

    writer.write("$count")
    writer.flush()
}