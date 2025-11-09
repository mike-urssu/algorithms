package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1863
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = Array(n) {
        val (_, y) = readln().split(" ").map { it.toInt() }
        y
    }

    var count = 0
    val stack = Stack<Int>()
    heights.forEach { h ->
        while (stack.isNotEmpty() && stack.peek() > h) {
            stack.pop()
            count++
        }
        if (stack.isNotEmpty() && stack.peek() == h) {
            stack.pop()
        }
        stack.push(h)
    }

    while (stack.isNotEmpty()) {
        if (stack.pop() > 0) {
            count++
        }
    }

    println(count)
}
