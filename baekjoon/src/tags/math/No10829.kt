package tags.math

/**
 * https://www.acmicpc.net/problem/10829
 */
import java.util.Stack

fun main() {
    val n = readln().toLong()

    var v = n
    val stack = Stack<Long>()
    while (v != 0L) {
        stack.push(v % 2L)
        v /= 2
    }

    while (stack.isNotEmpty()) {
        print(stack.pop())
    }
}
