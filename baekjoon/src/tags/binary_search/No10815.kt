package tags.binary_search

/**
 * https://www.acmicpc.net/problem/10815
 */
fun main() {
    readln()
    val cards = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    numbers.forEach {
        if (isExist(cards, it)) {
            print("1 ")
        } else {
            print("0 ")
        }
    }
}

private fun isExist(cards: IntArray, n: Int): Boolean {
    var low = 0
    var high = cards.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (cards[mid] > n) {
            high = mid
        } else {
            low = mid
        }
    }
    return cards[low] == n
}
