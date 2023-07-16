package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/10866
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val deque = LinkedList<Int>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val operations = reader.readLine().split(" ")
        if (operations[0] == "push_front")
            deque.addFirst(operations[1].toInt())
        else if (operations[0] == "push_back")
            deque.addLast(operations[1].toInt())
        else if (operations[0] == "pop_front") {
            writer.write("${if (deque.isEmpty()) -1 else deque.pollFirst()}")
            writer.newLine()
        } else if (operations[0] == "pop_back") {
            writer.write("${if (deque.isEmpty()) -1 else deque.pollLast()}")
            writer.newLine()
        } else if (operations[0] == "size") {
            writer.write("${deque.size}")
            writer.newLine()
        } else if (operations[0] == "empty") {
            writer.write("${if (deque.isEmpty()) 1 else 0}")
            writer.newLine()
        } else if (operations[0] == "front") {
            writer.write("${if (deque.isEmpty()) -1 else deque.peekFirst()}")
            writer.newLine()
        } else if (operations[0] == "back") {
            writer.write("${if (deque.isEmpty()) -1 else deque.peekLast()}")
            writer.newLine()
        }
    }
    writer.flush()
}
