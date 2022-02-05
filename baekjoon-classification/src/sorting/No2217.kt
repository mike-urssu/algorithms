package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2217
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numberOfInput = reader.readLine().toInt()
    val ropes = IntArray(numberOfInput)
    for (i in 0 until numberOfInput)
        ropes[i] = reader.readLine().toInt()

    ropes.sort()

    var countOfRopes = numberOfInput
    var max = Int.MIN_VALUE
    for (rope in ropes)
        max = max.coerceAtLeast(rope * countOfRopes--)
    writer.write(max.toString())
    writer.flush()
}
