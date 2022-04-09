package dataStructure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10816
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val cards = mutableMapOf<Int, Int>()
    reader.readLine().split(" ").map { it.toInt() }
        .forEach { number ->
            cards[number] = cards.getOrDefault(number, 0) + 1
        }

    val numberOfInput = reader.readLine().toInt()
    val counts = IntArray(numberOfInput)
    reader.readLine().split(" ").map { it.toInt() }
        .forEachIndexed { index, number ->
            counts[index] = cards.getOrDefault(number, 0)
        }
    writer.write(counts.joinToString(" "))
    writer.flush()
}
