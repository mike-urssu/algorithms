package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1253
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val count = (0 until n).count { i -> canMakeN(n, numbers, numbers[i], i) }
    println(count)
}

private fun canMakeN(n: Int, numbers: IntArray, sum: Int, index: Int): Boolean {
    for (i in 0 until n) {
        if (i == index) {
            continue
        }

        val indices = getLowerBound(numbers, sum - numbers[i]) until getLowerBound(numbers, sum - numbers[i] + 1)
        for (j in indices) {
            if (j != index && j != i && numbers[i] + numbers[j] == sum) {
                return true
            }
        }
    }

    return false
}

private fun getLowerBound(numbers: IntArray, n: Int): Int {
    var low = -1
    var high = numbers.lastIndex
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
