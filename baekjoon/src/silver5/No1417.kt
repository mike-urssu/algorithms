package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/1417
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()

    val vote = reader.readLine().toInt()
    val votes = PriorityQueue<Int>(Comparator.reverseOrder())
    repeat(numberOfInput - 1) {
        votes.add(reader.readLine().toInt())
    }

    var count = 0
    while (votes.isNotEmpty() && vote + count <= votes.peek()) {
        votes.add(votes.poll() - 1)
        count++
    }

    writer.write("$count")
    writer.flush()
}