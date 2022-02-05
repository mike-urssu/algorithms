package sorting

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

    reader.readLine().toInt()
    val cards = reader.readLine().split(' ').map { it.toInt() }.sorted()
    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }

    val countOfCards = HashMap<Int, Int>()
    for (card in cards)
        countOfCards[card] = countOfCards.getOrDefault(card, 0) + 1

    for (number in numbers)
        writer.write("${countOfCards.getOrDefault(number, 0)} ")
    writer.flush()
}
