package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Deque
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/10866
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val deque: Deque<String> = LinkedList()
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val commands = reader.readLine().split(" ")
        if (commands[0] == "push_front")
            deque.addFirst(commands[1])
        else if (commands[0] == "push_back")
            deque.addLast(commands[1])
        else if (commands[0] == "pop_front")
            writer.write("${if (deque.isEmpty()) "-1" else deque.pollFirst()}\n")
        else if (commands[0] == "pop_back")
            writer.write("${if (deque.isEmpty()) "-1" else deque.pollLast()}\n")
        else if (commands[0] == "size")
            writer.write("${deque.size}\n")
        else if (commands[0] == "empty")
            writer.write("${if (deque.isEmpty()) "1" else "0"}\n")
        else if (commands[0] == "front")
            writer.write("${if (deque.isEmpty()) "-1" else deque.peekFirst()}\n")
        else if (commands[0] == "back")
            writer.write("${if (deque.isEmpty()) "-1" else deque.peekLast()}\n")
    }
    writer.flush()
}