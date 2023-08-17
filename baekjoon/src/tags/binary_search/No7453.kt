package tags.binary_search

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
    val arrayA = LongArray(n)
    val arrayB = LongArray(n)
    val arrayC = LongArray(n)
    val arrayD = LongArray(n)

    repeat(n) { i ->
        val (a, b, c, d) = reader.readLine().split(" ").map { it.toLong() }
        arrayA[i] = a
        arrayB[i] = b
        arrayC[i] = c
        arrayD[i] = d
    }

    val newArray1 = mergeArrays(arrayA, arrayB)
    val newArray2 = mergeArrays(arrayC, arrayD)
    val count = newArray1.sumOf { getLowerBound(newArray2, -it.toInt() + 1) - getLowerBound(newArray2, -it.toInt()) }

    writer.write("$count")
    writer.flush()
}

private fun mergeArrays(array1: LongArray, array2: LongArray): LongArray {
    val newArray = LongArray(array1.size * array2.size)
    for (i in array1.indices) {
        for (j in array2.indices) {
            newArray[array1.size * i + j] = array1[i] + array2[j]
        }
    }
    return newArray.sortedArray()
}

private fun getLowerBound(numbers: LongArray, number: Int): Long {
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
    return high.toLong()
}
