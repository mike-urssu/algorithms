package tags.data_structures

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
        println(getMaxArea(rects, 1, n))
    }
}

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
