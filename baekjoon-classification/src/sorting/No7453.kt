package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/7453
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val arrayA = arrayListOf<Int>()
    val arrayB = arrayListOf<Int>()
    val arrayC = arrayListOf<Int>()
    val arrayD = arrayListOf<Int>()
    repeat(numberOfInput) {
        val numbers = reader.readLine().split(' ').map { it.toInt() }
        arrayA.add(numbers[0])
        arrayB.add(numbers[1])
        arrayC.add(numbers[2])
        arrayD.add(numbers[3])
    }

    val arrayAB = getMergedArray(arrayA, arrayB)
    val arrayCD = getMergedArray(arrayC, arrayD)

    var count = 0L
    for (number in arrayAB)
        count += getUpperBound(arrayCD, -number) - getLowerBound(arrayCD, -number)

    writer.write(count.toString())
    writer.flush()
}

private fun getMergedArray(array1: List<Int>, array2: List<Int>): IntArray {
    val size = array1.size
    val mergedArray = IntArray(size * size)
    for (i in array1.indices) {
        for (j in array2.indices)
            mergedArray[i * size + j] = array1[i] + array2[j]
    }
    mergedArray.sort()
    return mergedArray
}

private fun getLowerBound(array: IntArray, number: Int): Int {
    var low = -1
    var high = array.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (array[mid] < number)
            low = mid
        else
            high = mid
    }
    return high
}

private fun getUpperBound(array: IntArray, number: Int): Int {
    var low = -1
    var high = array.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (array[mid] <= number)
            low = mid
        else
            high = mid
    }
    return high
}
