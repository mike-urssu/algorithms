package tags.data_structures

/**
 * https://www.acmicpc.net/problem/3986
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val count = (0 until n).count { isGoodWord(readln()) }
    println(count)
}

private fun isGoodWord(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        if (stack.isEmpty()) {
            stack.add(it)
        } else {
            if (stack.peek() == it) {
                stack.pop()
            } else {
                stack.add(it)
            }
        }
    }
    return stack.isEmpty()
}
