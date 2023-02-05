package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

/**
 * https://www.acmicpc.net/problem/2161
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val queue: Queue<Int> = LinkedList()

    val number = reader.readLine().toInt()
    for (i in 1..number) {
        queue.add(i)
    }

    while (queue.size != 1) {
        writer.write("${queue.poll()} ")
        queue.add(queue.poll())
    }
    writer.write("${queue.poll()}")
    writer.flush()
}