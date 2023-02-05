package tags.dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/10845
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val queue = LinkedList<Int>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val operations = reader.readLine().split(" ")
        if (operations[0] == "push")
            queue.add(operations[1].toInt())
        else if (operations[0] == "pop") {
            writer.write("${if (queue.isEmpty()) -1 else queue.pop()}")
            writer.newLine()
        } else if (operations[0] == "size") {
            writer.write("${queue.size}")
            writer.newLine()
        } else if (operations[0] == "empty") {
            writer.write("${if (queue.isEmpty()) 1 else 0}")
            writer.newLine()
        } else if (operations[0] == "front") {
            writer.write("${if (queue.isEmpty()) -1 else queue.first}")
            writer.newLine()
        } else {
            writer.write("${if (queue.isEmpty()) -1 else queue.last}")
            writer.newLine()
        }
    }
    writer.flush()
}
