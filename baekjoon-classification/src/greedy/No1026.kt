package greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine().toInt()
    val firstArray = reader.readLine().split(' ').map { number -> number.toInt() }.sorted().reversed()
    val secondArray = reader.readLine().split(' ').map { number -> number.toInt() }.sorted()

    var sum = 0
    for (i in firstArray.indices)
        sum += firstArray[i] * secondArray[i]

    writer.write(sum.toString())
    writer.flush()
}
