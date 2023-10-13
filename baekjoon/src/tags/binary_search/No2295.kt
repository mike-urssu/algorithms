package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2295
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }.sortedArray()
    println(findD(n, numbers))
}

private fun findD(n: Int, numbers: IntArray): Int {
    var d = 0
    for (i in 0 until n) {
        for (j in i until n) {
            for (k in j until n) {
                val sum = numbers[i] + numbers[j] + numbers[k]
                if (sum > numbers.last()) {
                    break
                } else if (sum == numbers.last()) {
                    return sum
                } else {
                    val lowerBound = getLowerBound(numbers, sum)
                    if (lowerBound in numbers.indices && sum == numbers[lowerBound]) {
                        d = d.coerceAtLeast(sum)
                    }
                }
            }
        }
    }
    return d
}

private fun getLowerBound(numbers: IntArray, n: Int): Int {
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
