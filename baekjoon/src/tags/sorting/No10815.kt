package tags.sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10815
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val cards = reader.readLine().split(' ').map { it.toInt() }.sorted()
    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }

    for (number in numbers)
        writer.write("${if (contains(cards, number)) 1 else 0} ")
    writer.flush()
}

private fun contains(cards: List<Int>, number: Int): Boolean {
    var low = -1
    var high = cards.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (cards[mid] < number)
            low = mid
        else if (cards[mid] == number)
            return true
        else
            high = mid
    }
    if (low == -1)
        return false
    return cards[low] == number
}
