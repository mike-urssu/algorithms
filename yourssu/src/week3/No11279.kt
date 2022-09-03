package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * https://www.acmicpc.net/problem/11279
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val priorityQueue = PriorityQueue<Int> { it, other -> -it.compareTo(other) }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val number = reader.readLine().toInt()
        if (number > 0)
            priorityQueue.add(number)
        else if (number == 0)
            writer.write("${if (priorityQueue.isEmpty()) 0 else priorityQueue.poll()}\n")
    }
    writer.flush()
}