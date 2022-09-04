package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9012
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val parentheses = reader.readLine()
        writer.write("${if (isVPS(parentheses)) "YES" else "NO"}\n")
    }
    writer.flush()
}

private fun isVPS(parentheses: String): Boolean {
    val stack = Stack<Char>()
    for (parenthesis in parentheses) {
        if (parenthesis == '(')
            stack.push(parenthesis)
        else {
            if (stack.isEmpty() || stack.pop() != '(')
                return false
        }
    }
    return stack.isEmpty()
}