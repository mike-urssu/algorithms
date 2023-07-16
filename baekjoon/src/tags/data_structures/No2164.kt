package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/2164
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val queue = LinkedList<Int>()

    val numberOfInput = reader.readLine().toInt()
    for (number in 1..numberOfInput)
        queue.add(number)

    while (queue.size != 1) {
        queue.pop()
        queue.add(queue.pop())
    }

    writer.write("${queue.pop()}")
    writer.flush()
}
