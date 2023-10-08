package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2143
 */
fun main() {
    val t = readln().toInt()
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()

    val subSums1 = getSubSums(n, a)
    val subSums2 = getSubSums(m, b)

    val count = subSums1.sumOf {
        val upperBound = getLowerBound(subSums2, t - it + 1)
        val lowerBound = getLowerBound(subSums2, t - it)
        (upperBound - lowerBound).toLong()
    }
    println(count)
}

private fun getSubSums(n: Int, numbers: IntArray): List<Int> {
    val prefixSum = numbers.runningFold(0, Int::plus)
    val subSums = mutableListOf<Int>()
    for (i in 1..n) {
        for (j in 0..n - i) {
            subSums.add(prefixSum[j + i] - prefixSum[j])
        }
    }
    return subSums.sorted()
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
