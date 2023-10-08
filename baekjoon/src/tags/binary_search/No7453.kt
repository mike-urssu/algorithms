package tags.binary_search

/**
 * https://www.acmicpc.net/problem/7453
 */
fun main() {
    val n = readln().toInt()
    val arrayA = IntArray(n)
    val arrayB = IntArray(n)
    val arrayC = IntArray(n)
    val arrayD = IntArray(n)
    repeat(n) { i ->
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        arrayA[i] = a
        arrayB[i] = b
        arrayC[i] = c
        arrayD[i] = d
    }
    println(countWhoseSumIsZero(n, arrayA, arrayB, arrayC, arrayD))
}

private fun countWhoseSumIsZero(n: Int, arrayA: IntArray, arrayB: IntArray, arrayC: IntArray, arrayD: IntArray): Long {
    val sum1 = merge(n, arrayA, arrayB)
    val sum2 = merge(n, arrayC, arrayD)
    return sum1.sumOf { (getLowerBound(sum2, -it + 1) - getLowerBound(sum2, -it)).toLong() }
}

private fun merge(n: Int, array1: IntArray, array2: IntArray): IntArray {
    val array = IntArray(n * n)
    for (i in 0 until n) {
        for (j in 0 until n) {
            array[i * n + j] = array1[i] + array2[j]
        }
    }
    return array.sortedArray()
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
