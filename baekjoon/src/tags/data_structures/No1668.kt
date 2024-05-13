package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1668
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = IntArray(n) { readln().toInt() }
    println(count(heights))
    println(count(heights.reversedArray()))
}

private fun count(heights: IntArray): Int {
    val stack = Stack<Int>()
    heights.forEach { h ->
        if (stack.isEmpty()) {
            stack.push(h)
        } else {
            if (stack.peek() < h) {
                stack.push(h)
            }
        }
    }
    return stack.size
}
