package tags.data_structures

/**
 * https://www.acmicpc.net/problem/6198
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = IntArray(n) { readln().toInt() }
    println(count(heights))
}

private fun count(heights: IntArray): Long {
    var count = 0L
    val stack = Stack<Int>()
    heights.forEach {
        while (stack.isNotEmpty() && stack.peek() <= it) {
            stack.pop()
        }
        count += stack.size
        stack.push(it)
    }
    return count
}
