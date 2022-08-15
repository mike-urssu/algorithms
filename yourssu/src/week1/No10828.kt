package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/10828
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val stack = Stack<String>()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val commands = reader.readLine().split(" ")
        if (commands.size == 2)
            stack.push(commands[1])
        else {
            if (commands[0] == "pop")
                writer.write(if (stack.isEmpty()) "-1" else stack.pop())
            else if (commands[0] == "size")
                writer.write(stack.size.toString())
            else if (commands[0] == "empty")
                writer.write(if (stack.isEmpty()) "1" else "0")
            else
                writer.write(if (stack.isEmpty()) "-1" else stack.peek())
            writer.newLine()
        }
    }

    writer.flush()
}