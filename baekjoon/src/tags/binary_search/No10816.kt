package tags.binary_search

/**
 * https://www.acmicpc.net/problem/10816
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    reader.readLine()
    val cards = reader.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val counts = StringBuffer()
    numbers.forEach { counts.append("${getLowerBound(cards, it + 1) - getLowerBound(cards, it)} ") }
    println(counts)
}

private fun getLowerBound(cards: IntArray, n: Int): Int {
    var low = -1
    var high = cards.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (cards[mid] < n) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}
