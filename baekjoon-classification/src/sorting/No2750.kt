package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2750
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        numbers[i] = reader.readLine().toInt()

    for (i in numbers.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (numbers[j] > numbers[j + 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }

    for (number in numbers) {
        writer.write(number.toString())
        writer.newLine()
    }
    writer.flush()
}
