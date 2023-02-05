package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1015
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput)
    val tokenizer = StringTokenizer(reader.readLine())
    for (i in numbers.indices)
        numbers[i] = tokenizer.nextToken().toInt()
    val arrayP = IntArray(numberOfInput)

    val sortedNumbers = numbers.sorted()
    for (i in numbers.indices) {
        val index = numbers.indexOf(sortedNumbers[i])
        numbers[index] = -1
        arrayP[index] = i
    }

    for (number in arrayP)
        writer.write("$number ")
    writer.flush()
}
