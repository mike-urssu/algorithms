package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1662
 */
import java.util.Stack

fun main() {
    val s = readln()
    val stack = Stack<String>()
    s.indices.forEach { i ->
        when (s[i]) {
            '(' -> stack.push("(")
            ')' -> {
                var q = 0
                while (stack.peek() != "(") {
                    q += if (stack.peek().startsWith("kq")) {
                        stack.pop().substring(2).toInt()
                    } else {
                        stack.pop()
                        1
                    }
                }
                stack.pop()     // remove '('

                val k = if (stack.peek().startsWith("kq")) {
                    stack.pop().substring(2).toInt()
                } else {
                    stack.pop().toInt()
                }
                stack.push("kq${q * k}")
            }

            else -> stack.push(s[i].toString())
        }
    }

    var sum = 0
    while (stack.isNotEmpty()) {
        sum += if (stack.peek().startsWith("kq")) {
            stack.pop().substring(2).toInt()
        } else {
            stack.pop()
            1
        }
    }
    println(sum)
}
