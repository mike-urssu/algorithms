package tags.binary_search

/**
 * https://www.acmicpc.net/problem/14003
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val lcs = getLcs(n, numbers)
    println(lcs.size)
    println(lcs.joinToString(" "))
}

private fun getLcs(n: Int, numbers: IntArray): List<Int> {
    val indices = getIndices(n, numbers)
    val lcs = mutableListOf<Int>()
    var index = indices.max()

    var i = n - 1
    while (index >= 0) {
        if (indices[i] == index) {
            lcs.add(numbers[i])
            index--
        }
        i--
    }

    return lcs.reversed()
}

private fun getIndices(n: Int, numbers: IntArray): IntArray {
    val sequence = mutableListOf(numbers[0])
    val indices = IntArray(n) { it }
    for (i in 1 until n) {
        val lowerBound = getLowerBound(sequence, numbers[i])
        if (lowerBound == sequence.size) {
            sequence.add(numbers[i])
        } else {
            sequence[lowerBound] = numbers[i]
        }
        indices[i] = lowerBound
    }
    return indices
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
