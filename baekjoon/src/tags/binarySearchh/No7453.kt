package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/7453
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val arrayA = IntArray(n)
    val arrayB = IntArray(n)
    val arrayC = IntArray(n)
    val arrayD = IntArray(n)

    repeat(n) { i ->
        val (a, b, c, d) = reader.readLine().split(" ").map { it.toInt() }
        arrayA[i] = a
        arrayB[i] = b
        arrayC[i] = c
        arrayD[i] = d
    }

    val newArray1 = mergeArrays(arrayA, arrayB)
    val newArray2 = mergeArrays(arrayC, arrayD)
    var count = 0L
    for (number in newArray1) {
        count += getUpperBound(newArray2, -number) - getLowerBound(newArray2, -number)
    }

    writer.write("$count")
    writer.flush()
}

private fun mergeArrays(array1: IntArray, array2: IntArray): IntArray {
    val newArray = IntArray(array1.size * array2.size)
    for (i in array1.indices) {
        for (j in array2.indices) {
            newArray[array1.size * i + j] = array1[i] + array2[j]
        }
    }
    return newArray.sortedArray()
}

private fun getLowerBound(numbers: IntArray, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] >= number) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun getUpperBound(numbers: IntArray, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] <= number) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}
