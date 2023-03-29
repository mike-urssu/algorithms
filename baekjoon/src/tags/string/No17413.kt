package tags.string

import java.util.Stack

/**
 * https://www.acmicpc.net/problem/17413
 */
fun main() {
    val line = readln()

    val s = StringBuilder()

    val stack = Stack<Char>()
    var index = 0
    while (index < line.length) {
        when (val c = line[index++]) {
            '<' -> {
                s.append(popAll(stack))
                s.append(c)

                while (true) {
                    val ch = line[index++]
                    if (ch == '>') {
                        s.append(ch)
                        break
                    } else {
                        s.append(ch)
                    }
                }
            }

            ' ' -> {
                s.append(popAll(stack))
                s.append(c)
            }

            else -> {
                stack.push(c)
            }
        }
    }

    s.append(popAll(stack))
    println(s.toString())
}

private fun popAll(stack: Stack<Char>): String {
    val s = StringBuilder()
    while (stack.isNotEmpty()) {
        s.append(stack.pop())
    }
    return s.toString()
}
