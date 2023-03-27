package tags.string

import java.util.Stack

/**
 * https://www.acmicpc.net/problem/4949
 */
fun main() {
    while (true) {
        val line = readln()
        if (line == ".") {
            break
        }
        if (isValid(line)) {
            println("yes")
        } else {
            println("no")
        }
    }
}

private fun isValid(line: String): Boolean {
    val stack = Stack<Char>()
    line.forEach {
        when (it) {
            '(' -> stack.push(it)
            '[' -> stack.push(it)
            ')' -> {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false
                }
            }

            ']' -> {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}
