package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2752
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ').map { it.toInt() }.toMutableList()
    for (i in 1 until numbers.size) {
        val number = numbers[i]
        var index = i
        for (j in i - 1 downTo 0) {
            if (number < numbers[j])
                index = j
            else
                break
        }
        numbers.removeAt(i)
        numbers.add(index, number)
    }

    for (number in numbers)
        writer.write("$number ")
    writer.flush()
}
