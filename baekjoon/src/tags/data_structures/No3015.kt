package tags.data_structures

/**
 * https://www.acmicpc.net/problem/3015
 */
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = IntArray(n) { readln().toInt() }
    println(getViewablePairs(heights))
}

private fun getViewablePairs(heights: IntArray): Long {
    val stack = Stack<Pair<Int, Int>>()

    var viewablePairs = 0L
    heights.forEach { height ->
        var count = 1

        while (stack.isNotEmpty()) {
            val (h, c) = stack.peek()
            if (h > height) {
                break
            }

            if (h == height) {
                count += c
            }

            viewablePairs += c
            stack.pop()
        }

        if (stack.isNotEmpty()) {
            viewablePairs++
        }

        stack.push(Pair(height, count))
    }
    return viewablePairs
}
