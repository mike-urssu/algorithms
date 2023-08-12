package tags.data_structures

/**
 * https://www.acmicpc.net/problem/2504
 */
import java.util.Stack

fun main() {
    val s = readln()
    println(getValue(s))
}

private fun getValue(s: String): Int {
    var sum = 0
    var mul = 1

    val stack = Stack<Char>()
    s.forEachIndexed { i, it ->
        when (it) {
            '(' -> {
                mul *= 2
                stack.push(it)
            }

            '[' -> {
                mul *= 3
                stack.push(it)
            }

            ')' -> {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0
                } else if (s[i - 1] == '(') {
                    sum += mul
                }
                mul /= 2
                stack.pop()
            }

            ']' -> {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0
                } else if (s[i - 1] == '[') {
                    sum += mul
                }
                mul /= 3
                stack.pop()
            }
        }
    }

    return if (stack.isEmpty()) {
        sum
    } else {
        0
    }
}
