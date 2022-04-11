package dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/4949
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val input = reader.readLine()
        if (input == ".")
            break
        writer.write(if (isBalanced(input)) "yes" else "no")
        writer.newLine()
    }
    writer.flush()
}

private fun isBalanced(input: String): Boolean {
    val stack = Stack<Char>()
    for (character in input) {
        if (character == '(' || character == '[')
            stack.push(character)
        else if (character == ')') {
            if (stack.isEmpty() || stack.peek() != '(')
                return false
            else
                stack.pop()
        } else if (character == ']') {
            if (stack.isEmpty() || stack.peek() != '[')
                return false
            else
                stack.pop()
        }
    }
    return stack.isEmpty()
}
