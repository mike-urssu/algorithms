package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1918
 */
import java.util.Stack

fun main() {
    val s = readln()
    println(getPostfixExpression(s))
}

private fun getPostfixExpression(s: String): String {
    val expression = StringBuilder()
    val stack = Stack<Char>()
    s.forEach {
        when (it) {
            '+', '-' -> {
                while (stack.isNotEmpty() && stack.peek() != '(') {
                    expression.append(stack.pop())
                }
                stack.push(it)
            }

            '*', '/' -> {
                while (stack.isNotEmpty() && stack.peek() !in charArrayOf('(', '+', '-')) {
                    expression.append(stack.pop())
                }
                stack.push(it)
            }

            '(' -> {
                stack.push(it)
            }

            ')' -> {
                while (stack.peek() != '(') {
                    expression.append(stack.pop())
                }
                stack.pop()
            }

            else -> {
                expression.append(it)
            }
        }
    }
    while (stack.isNotEmpty()) {
        expression.append(stack.pop())
    }
    return expression.toString()
}
