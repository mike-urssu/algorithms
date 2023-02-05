package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        numbers[i] = reader.readLine().toInt()

    writer.flush()
}
