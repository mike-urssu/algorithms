package sorting

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val sortedNumbers = bubbleSort()
    for (number in sortedNumbers)
        writer.write("$number ")
    writer.flush()
}

fun bubbleSort(): IntArray {
    val numbers = intArrayOf(5, 2, 3, 4, 1)
    for (i in numbers.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (numbers[j] > numbers[j + 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }
    return numbers
}
