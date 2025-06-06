package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/3151
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    var count = 0L
    for (left in 0 until n - 1) {
        for (mid in left + 1 until n) {
            val sum = numbers[left] + numbers[mid]
            val leftIndex = getUpperBound(numbers, mid, n, -sum)
            val rightIndex = getUpperBound(numbers, mid, n, -sum + 1)
            count += rightIndex - leftIndex
        }
    }
    println(count)
}

private fun getUpperBound(numbers: IntArray, from: Int, to: Int, v: Int): Int {
    var left = from
    var right = to
    while (left + 1 < right) {
        val mid = (left + right) shr 1
        if (v <= numbers[mid]) {
            right = mid
        } else {
            left = mid
        }
    }
    return right
}
