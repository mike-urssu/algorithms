package tags.string

import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9012
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val parentheses = readln()
        if (isValid(parentheses)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isValid(parentheses: String): Boolean {
    val stack = Stack<Char>()
    val open = '('
    val closed = ')'
    for (p in parentheses) {
        if (p == open) {
            stack.push(open)
        } else if (p == closed) {
            if (stack.isEmpty()) {
                return false
            } else if (stack.peek() == closed) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty()
}
