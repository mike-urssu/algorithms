package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/1524
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        reader.readLine()
        reader.readLine()
        val soldiers1 = PriorityQueue(reader.readLine().split(" ").map { it.toInt() }.toSortedSet())
        val soldiers2 = PriorityQueue(reader.readLine().split(" ").map { it.toInt() }.toSortedSet())

        while (soldiers1.size != 0 && soldiers2.size != 0) {
            if (soldiers1.peek() == soldiers2.peek()) {
                soldiers2.poll()
            } else if (soldiers1.peek() > soldiers2.peek()) {
                soldiers2.poll()
            } else {
                soldiers1.poll()
            }
        }

        if (soldiers1.isNotEmpty()) {
            writer.write("S")
        } else if (soldiers2.isNotEmpty()) {
            writer.write("B")
        } else {
            writer.write("C")
        }

        writer.write("\n")
    }

    writer.flush()
}
