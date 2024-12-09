package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11899
 */
import java.util.Stack

fun main() {
    val stack = Stack<Char>()
    val s = readln()
    for (c in s) {
        if (c == ')') {
            if (stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop()
                continue
            }
        }
        stack.push(c)
    }
    println(stack.size)
}
