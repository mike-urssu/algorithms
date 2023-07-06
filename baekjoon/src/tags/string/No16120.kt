package tags.string

/**
 * https://www.acmicpc.net/problem/16120
 */
import java.util.Stack

fun main() {
    val s = readln()
    if (isValid(s)) {
        println("PPAP")
    } else {
        println("NP")
    }
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        stack.push(it)
        changeIfValid(stack)
    }
    return stack.size == 1 && stack.peek() == 'P'
}

private fun changeIfValid(stack: Stack<Char>) {
    while (true) {
        if (stack.size < 4 || stack.peek() == 'A') {
            return
        }
        val first = stack.pop()
        val second = stack.pop()
        val third = stack.pop()
        val forth = stack.pop()
        if (first == 'P' && second == 'A' && third == 'P' && forth == 'P') {
            stack.push('P')
        } else {
            stack.push(forth)
            stack.push(third)
            stack.push(second)
            stack.push(third)
            return
        }
    }
}
