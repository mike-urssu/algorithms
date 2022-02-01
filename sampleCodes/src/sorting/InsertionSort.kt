package sorting

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val sortedNumbers = insertionSort()
    for (number in sortedNumbers)
        writer.write("$number ")
    writer.flush()
}

fun insertionSort(): IntArray {
    val numbers = intArrayOf(5, 2, 3, 4, 1)
    for (i in 1 until numbers.size) {
        for (j in i downTo 1) {
            if (numbers[j] < numbers[j - 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = temp
            }
        }
    }
    return numbers
}
