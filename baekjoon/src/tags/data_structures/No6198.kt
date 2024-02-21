package tags.data_structures

/**
 * https://www.acmicpc.net/problem/6198
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = IntArray(n) { readln().toInt() }
    println(count(n, heights))
}

private fun count(n: Int, heights: IntArray): Long {
    var count = 0L
    val stack = Stack<Pair<Int, Int>>()
    (n - 1 downTo 0).forEach { i ->
        var buildings = 0
        while (stack.isNotEmpty()) {
            val (h, b) = stack.peek()
            if (h >= heights[i]) {
                break
            }
            stack.pop()
            buildings += b + 1
            count += b
        }
        stack.push(Pair(heights[i], buildings))
    }
    while (stack.isNotEmpty()) {
        count += stack.pop().second
    }
    return count
}
