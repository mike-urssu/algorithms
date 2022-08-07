package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/2161
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val queue = LinkedList<Int>()
    val number = reader.readLine().toInt()
    repeat(number) { queue.add(it + 1) }

    while (queue.size != 1) {
        writer.write("${queue.pollFirst()} ")
        queue.add(queue.pollFirst())
    }
    writer.write("${queue.poll()}")

    writer.flush()
}