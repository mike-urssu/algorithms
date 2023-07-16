package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/10828
 */
private val stack = Stack<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(BufferedWriter(OutputStreamWriter(System.out))) {
        val numberOfInput = readLine().toInt()
        repeat(numberOfInput) {
            val operations = readLine().split(" ")
            if (operations[0] == "push")
                stack.push(operations[1].toInt())
            else if (operations[0] == "pop") {
                write("${if (stack.isEmpty()) -1 else stack.pop()}")
                newLine()
            } else if (operations[0] == "top") {
                write("${if (stack.isEmpty()) -1 else stack.peek()}")
                newLine()
            } else if (operations[0] == "size") {
                write("${stack.size}")
                newLine()
            } else if (operations[0] == "empty") {
                write("${if (stack.isEmpty()) 1 else 0}")
                newLine()
            }
        }
        flush()
    }
}
