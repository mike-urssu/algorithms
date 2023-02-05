package tags.sorting

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

    for (number in numbers)
        writer.write("${getUpperBound(cards, number) - getLowerBound(cards, number)} ")
    writer.flush()
}

private fun getUpperBound(cards: List<Int>, number: Int): Int {
    var low = -1
    var high = cards.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (cards[mid] <= number)
            low = mid
        else
            high = mid
    }
    return high
}

private fun getLowerBound(cards: List<Int>, number: Int): Int {
    var low = -1
    var high = cards.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (cards[mid] >= number)
            high = mid
        else
            low = mid
    }
    return high
}

/*
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
*/