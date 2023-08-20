package tags.data_structures

import java.util.Stack

/**
 * https://www.acmicpc.net/problem/6549
 */
fun main() {
    while (true) {
        val rects = readln().split(" ").map { it.toLong() }
        val n = rects.first().toInt()
        if (n == 0) {
            break
        }
        println(getMaxArea(rects, n))
    }
}

/**
 * divide and conquer
 */
private fun getMaxArea(rects: List<Long>, low: Int, high: Int): Long {
    if (low == high) {
        return rects[low]
    }
    val mid = (low + high) / 2
    val leftArea = getMaxArea(rects, low, mid)
    val midArea = getMidArea(rects, low, mid, high)
    val rightArea = getMaxArea(rects, mid + 1, high)
    return maxOf(leftArea, midArea, rightArea)
}

private fun getMidArea(rects: List<Long>, low: Int, mid: Int, high: Int): Long {
    var leftIndex = mid
    var rightIndex = mid
    var height = rects[mid]
    var maxArea = rects[mid]

    while (low < leftIndex && rightIndex < high) {
        height = if (rects[leftIndex - 1] < rects[rightIndex + 1]) {
            rightIndex++
            height.coerceAtMost(rects[rightIndex])
        } else {
            leftIndex--
            height.coerceAtMost(rects[leftIndex])
        }
        maxArea = maxArea.coerceAtLeast(height * (rightIndex - leftIndex + 1))
    }

    while (low < leftIndex) {
        leftIndex--
        height = height.coerceAtMost(rects[leftIndex])
        maxArea = maxArea.coerceAtLeast(height * (rightIndex - leftIndex + 1))
    }

    while (rightIndex < high) {
        rightIndex++
        height = height.coerceAtMost(rects[rightIndex])
        maxArea = maxArea.coerceAtLeast(height * (rightIndex - leftIndex + 1))
    }

    return maxArea
}

/**
 * stack
 */
private fun getMaxArea(rects: List<Long>, n: Int): Long {
    var maxArea: Long = 0

    val stack = Stack<Int>()
    for (i in 1..n) {
        while (stack.isNotEmpty() && rects[i] <= rects[stack.peek()]) {
            val height = rects[stack.pop()]
            val width = if (stack.isEmpty()) {
                i - 1
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
            n - stack.peek()
        }
        maxArea = maxArea.coerceAtLeast(height * width)
    }

    return maxArea
}
