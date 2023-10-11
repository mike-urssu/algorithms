package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1365
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    print(cutLines(n, numbers))
}

private fun cutLines(n: Int, numbers: IntArray): Int {
    val lines = mutableListOf(numbers[0])
    (1 until n).forEach { i ->
        val lowerBound = getLowerBound(lines, numbers[i])
        if (lowerBound == lines.size) {
            lines.add(numbers[i])
        } else {
            lines[lowerBound] = numbers[i]
        }
    }
    return n - lines.size
}

private fun getLowerBound(numbers: List<Int>, n: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
