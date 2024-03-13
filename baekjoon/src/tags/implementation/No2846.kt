package tags.implementation

/**
 * https://www.acmicpc.net/problem/2846
 */
fun main() {
    val n = readln().toInt()
    val heights = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getGap(n, heights))
}

private fun getGap(n: Int, heights: IntArray): Int {
    var gap = 0
    var left = 0
    while (left < n) {
        var right = left
        for (i in left until n - 1) {
            if (heights[i] >= heights[i + 1]) {
                break
            }
            right = i + 1
        }
        gap = gap.coerceAtLeast(heights[right] - heights[left])
        left = right + 1
    }

    return gap
}
