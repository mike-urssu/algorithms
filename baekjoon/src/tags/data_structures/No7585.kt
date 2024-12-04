package tags.data_structures

/**
 * https://www.acmicpc.net/problem/7585
 */
import java.util.Stack

fun main() {
    while (true) {
        val s = readln()
        if (s == "#") {
            break
        }
        if (isLegal(s)) {
            println("Legal")
        } else {
            println("Illegal")
        }
    }
}

private fun isLegal(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { c ->
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c)
        } else if (c == ')') {
            val p = stack.pop()
            if (p != '(') {
                return false
            }
        } else if (c == '}') {
            val p = stack.pop()
            if (p != '{') {
                return false
            }
        } else if (c == ']') {
            val p = stack.pop()
            if (p != '[') {
                return false
            }
        }
    }
    return stack.isEmpty()
}
