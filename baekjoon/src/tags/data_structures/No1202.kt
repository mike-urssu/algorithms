package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1202
 */
import java.util.PriorityQueue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val jewels = getJewels(n)
    val bags = IntArray(k) { readln().toInt() }.sortedArray()
    println(getMaxPrice(jewels, bags))
}

private fun getJewels(n: Int): List<Pair<Int, Int>> {
    val jewels = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (m, v) = readln().split(" ").map { it.toInt() }
        jewels.add(Pair(m, v))
    }
    return jewels.sortedWith(compareBy({ it.first }, { -it.second }))
}

private fun getMaxPrice(jewels: List<Pair<Int, Int>>, bags: IntArray): Long {
    var sumOfPrice = 0L
    val queue = PriorityQueue<Int>(Comparator.reverseOrder())
    var i = 0
    for (bag in bags) {
        while (i < jewels.size && jewels[i].first <= bag) {
            queue.add(jewels[i++].second)
        }
        if (queue.isNotEmpty()) {
            sumOfPrice += queue.poll()
        }
    }
    return sumOfPrice
}
