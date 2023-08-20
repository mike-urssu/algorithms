package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1725
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val rects = IntArray(n) { readln().toInt() }
    println(getMaxArea(rects, n))
}

private fun getMaxArea(rects: IntArray, n: Int): Int {
    var maxArea = 0

    val stack = Stack<Int>()
    for (i in rects.indices) {
        while (stack.isNotEmpty() && rects[i] <= rects[stack.peek()]) {
            val height = rects[stack.pop()]
            val width = if (stack.isEmpty()) {
                i
            } else {
                i - 1 - stack.peek()
            }
            maxArea = maxArea.coerceAtLeast(height * width)
        }
        stack.push(i)
    }

    while (stack.isNotEmpty()) {
        val height = rects[stack.pop()]
        val width = if (stack.isEmpty()) {
            n
        } else {
            n - 1 - stack.peek()
        }
        maxArea = maxArea.coerceAtLeast(height * width)
    }

    return maxArea
}
