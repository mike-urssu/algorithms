package tags.data_structures

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9012
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val stack = Stack<Char>()
        var isValid = true

        val parentheses = reader.readLine()
        for (parenthesis in parentheses) {
            if (parenthesis == '(')
                stack.push(parenthesis)
            else {
                if (stack.isEmpty() || stack.pop() == ')') {
                    isValid = false
                    break
                }
            }
        }
        if (!stack.isEmpty())
            isValid = false

        writer.write(if (isValid) "YES" else "NO")
        writer.newLine()
    }
    writer.flush()
}
