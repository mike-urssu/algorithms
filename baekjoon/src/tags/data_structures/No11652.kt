package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11652
 */
import java.util.SortedMap

fun main() {
    val n = readln().toInt()
    val cards = getCards(n)
    val max = cards.values.max()
    println(cards.filterValues { it == max }.keys.first())
}

private fun getCards(n: Int): SortedMap<Long, Int> {
    val cards = sortedMapOf<Long, Int>()
    repeat(n) {
        val number = readln().toLong()
        cards[number] = (cards[number] ?: 0) + 1
    }
    return cards
}
