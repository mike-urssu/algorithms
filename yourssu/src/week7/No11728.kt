package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11728
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val a = reader.readLine().split(" ").map { it.toInt() }
    val b = reader.readLine().split(" ").map { it.toInt() }
    mergeSort(a, b).forEach { writer.write("$it ") }
    writer.flush()
}

private fun mergeSort(a: List<Int>, b: List<Int>): IntArray {
    val sortedArray = IntArray(a.size + b.size)
    var index = 0

    var i = 0
    var j = 0
    while (i < a.size && j < b.size) {
        if (a[i] < b[j]) {
            sortedArray[index++] = a[i++]
        } else {
            sortedArray[index++] = b[j++]
        }
    }

    if (i == a.size) {
        while (j < b.size) {
            sortedArray[index++] = b[j++]
        }
    }
    if (j == b.size) {
        while (i < a.size) {
            sortedArray[index++] = a[i++]
        }
    }

    return sortedArray
}